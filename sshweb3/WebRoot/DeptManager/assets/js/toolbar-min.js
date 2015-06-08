/**
 * @fileOverview \u5de5\u5177\u680f\u547d\u540d\u7a7a\u95f4\u5165\u53e3
 * @ignore
 */
define("bui/toolbar", ["bui/common", "bui/toolbar/baritem", "bui/toolbar/bar", "bui/toolbar/pagingbar", "bui/toolbar/numberpagingbar"], function(e) {
	var t = e("bui/common"),
		n = t.namespace("Toolbar");
	return t.mix(n, {
		BarItem: e("bui/toolbar/baritem"),
		Bar: e("bui/toolbar/bar"),
		PagingBar: e("bui/toolbar/pagingbar"),
		NumberPagingBar: e("bui/toolbar/numberpagingbar")
	}), n
}), define("bui/toolbar/baritem", function() {
	var e = BUI.prefix,
		t = BUI.Component,
		n = t.UIBase,
		r = t.View.extend([n.ListItemView]),
		i = t.Controller.extend([n.ListItem], {
			renderUI: function() {
				var t = this.get("el");
				t.addClass(e + "inline-block"), t.attr("id") || t.attr("id", this.get("id"))
			}
		}, {
			ATTRS: {
				elTagName: {
					view: !0,
					value: "li"
				},
				selectable: {
					value: !1
				},
				focusable: {
					value: !1
				},
				xview: {
					value: r
				}
			}
		}, {
			xclass: "bar-item",
			priority: 1
		}),
		s = i.extend({
			_uiSetDisabled: function(t) {
				var n = this,
					r = n.get("el"),
					i = t ? "addClass" : "removeClass";
				r.find("button").attr("disabled", t)[i](e + "button-disabled")
			},
			_uiSetChecked: function(t) {
				var n = this,
					r = n.get("el"),
					i = t ? "addClass" : "removeClass";
				r.find("button")[i](e + "button-checked")
			},
			_uiSetText: function(e) {
				var t = this,
					n = t.get("el");
				n.find("button").text(e)
			},
			_uiSetbtnCls: function(e) {
				var t = this,
					n = t.get("el");
				n.find("button").addClass(e)
			}
		}, {
			ATTRS: {
				checked: {
					value: !1
				},
				tpl: {
					view: !0,
					value: '<button type="button" class="{btnCls}">{text}</button>'
				},
				btnCls: {
					sync: !1
				},
				text: {
					sync: !1,
					value: ""
				}
			}
		}, {
			xclass: "bar-item-button",
			priority: 2
		}),
		o = i.extend({
			renderUI: function() {
				var e = this.get("el");
				e.attr("role", "separator")
			}
		}, {
			xclass: "bar-item-separator",
			priority: 2
		}),
		u = i.extend({}, {
			ATTRS: {
				width: {
					view: !0,
					value: 2
				}
			}
		}, {
			xclass: "bar-item-spacer",
			priority: 2
		}),
		a = i.extend({
			_uiSetText: function(e) {
				var t = this,
					n = t.get("el");
				n.html(e)
			}
		}, {
			ATTRS: {
				text: {
					value: ""
				}
			}
		}, {
			xclass: "bar-item-text",
			priority: 2
		});
	return i.types = {
		button: s,
		separator: o,
		spacer: u,
		text: a
	}, i
}), define("bui/toolbar/bar", function() {
	var e = BUI.Component,
		t = e.UIBase,
		n = e.View.extend({
			renderUI: function() {
				var e = this.get("el");
				e.attr("role", "toolbar"), e.attr("id") || e.attr("id", BUI.guid("bar"))
			}
		}),
		r = e.Controller.extend([t.ChildList], {
			getItem: function(e) {
				return this.getChild(e)
			}
		}, {
			ATTRS: {
				elTagName: {
					view: !0,
					value: "ul"
				},
				defaultChildClass: {
					value: "bar-item"
				},
				focusable: {
					value: !1
				},
				xview: {
					value: n
				}
			}
		}, {
			xclass: "bar",
			priority: 1
		});
	return r
}), define("bui/toolbar/pagingbar", ["bui/toolbar/bar"], function(e) {
	var t = e("bui/toolbar/bar"),
		n = BUI.Component,
		r = n.UIBase.Bindable,
		i = BUI.prefix,
		s = "first",
		o = "prev",
		u = "next",
		a = "last",
		f = "skip",
		l = "totalPage",
		c = "curPage",
		h = "totalCount",
		p = t.extend([r], {
			initializer: function() {
				var e = this,
					t = e.get("children"),
					n = e.get("items"),
					r = e.get("store");
				if (!n || n.length) n = e._getItems(), BUI.each(n, function(e) {
					t.push(e)
				});
				r && r.get("pageSize") && e.set("pageSize", r.get("pageSize"))
			},
			bindUI: function() {
				var e = this;
				e._bindButtonEvent()
			},
			jumpToPage: function(e) {
				if (e <= 0 || e > this.get("totalPage")) return;
				var t = this,
					n = t.get("store"),
					r = t.get("pageSize"),
					i = e - 1,
					s = i * r,
					o = t.fire("beforepagechange", {
						from: t.get("curPage"),
						to: e
					});
				n && o !== !1 && n.load({
					start: s,
					limit: r,
					pageIndex: i
				})
			},
			_afterStoreLoad: function(e, t) {
				var n = this,
					r = n.get("pageSize"),
					i = 0,
					s, o, u, a;
				i = e.get("start"), o = e.getTotalCount(), s = o - i > r ? i + e.getCount() : o, a = parseInt((o + r - 1) / r, 10), a = a > 0 ? a : 1, u = parseInt(i / r, 10) + 1, n.set("start", i), n.set("end", s), n.set("totalCount", o), n.set("curPage", u), n.set("totalPage", a), n._setAllButtonsState(), n._setNumberPages()
			},
			_bindButtonEvent: function() {
				function n() {
					var t = parseInt(e._getCurrentPageValue(), 10);
					e._isPageAllowRedirect(t) ? e.jumpToPage(t) : e._setCurrentPageValue(e.get("curPage"))
				}
				var e = this;
				e._bindButtonItemEvent(s, function() {
					e.jumpToPage(1)
				}), e._bindButtonItemEvent(o, function() {
					e.jumpToPage(e.get("curPage") - 1)
				}), e._bindButtonItemEvent(u, function() {
					e.jumpToPage(e.get("curPage") + 1)
				}), e._bindButtonItemEvent(a, function() {
					e.jumpToPage(e.get("totalPage"))
				}), e._bindButtonItemEvent(f, function() {
					n()
				});
				var t = e.getItem(c);
				t && t.get("el").on("keyup", function(e) {
					e.stopPropagation(), e.keyCode === 13 && n()
				})
			},
			_bindButtonItemEvent: function(e, t) {
				var n = this,
					r = n.getItem(e);
				r && r.on("click", t)
			},
			onLoad: function(e) {
				var t = this,
					n = t.get("store");
				t._afterStoreLoad(n, e)
			},
			_getItems: function() {
				var e = this,
					t = e.get("items");
				return t && t.length ? t : (t = [], t.push(e._getButtonItem(s)), t.push(e._getButtonItem(o)), t.push(e._getSeparator()), t.push(e._getTextItem(l)), t.push(e._getTextItem(c)), t.push(e._getButtonItem(f)), t.push(e._getSeparator()), t.push(e._getButtonItem(u)), t.push(e._getButtonItem(a)), t.push(e._getSeparator()), t.push(e._getTextItem(h)), t)
			},
			_getButtonItem: function(e) {
				var t = this;
				return {
					id: e,
					xclass: "bar-item-button",
					text: t.get(e + "Text"),
					disabled: !0,
					elCls: t.get(e + "Cls")
				}
			},
			_getSeparator: function() {
				return {
					xclass: "bar-item-separator"
				}
			},
			_getTextItem: function(e) {
				var t = this;
				return {
					id: e,
					xclass: "bar-item-text",
					text: t._getTextItemTpl(e)
				}
			},
			_getTextItemTpl: function(e) {
				var t = this,
					n = {};
				return n[e] = t.get(e), BUI.substitute(this.get(e + "Tpl"), n)
			},
			_isPageAllowRedirect: function(e) {
				var t = this;
				return e && e > 0 && e <= t.get("totalPage") && e !== t.get("curPage")
			},
			_setAllButtonsState: function() {
				var e = this,
					t = e.get("store");
				t && e._setButtonsState([o, u, s, a, f], !0), e.get("curPage") === 1 && e._setButtonsState([o, s], !1), e.get("curPage") === e.get("totalPage") && e._setButtonsState([u, a], !1)
			},
			_setButtonsState: function(e, t) {
				var n = this,
					r = n.get("children");
				BUI.each(r, function(n) {
					BUI.Array.indexOf(n.get("id"), e) !== -1 && n.set("disabled", !t)
				})
			},
			_setNumberPages: function() {
				var e = this,
					t = e.getItem(l),
					n = e.getItem(h);
				t && t.set("content", e._getTextItemTpl(l)), e._setCurrentPageValue(e.get(c)), n && n.set("content", e._getTextItemTpl(h))
			},
			_getCurrentPageValue: function(e) {
				var t = this;
				e = e || t.getItem(c);
				var n = e.get("el").find("input");
				return n.val()
			},
			_setCurrentPageValue: function(e, t) {
				var n = this;
				t = t || n.getItem(c);
				var r = t.get("el").find("input");
				r.val(e)
			}
		}, {
			ATTRS: {
				firstText: {
					value: "\u9996 \u9875"
				},
				firstCls: {
					value: i + "pb-first"
				},
				prevText: {
					value: "\u4e0a\u4e00\u9875"
				},
				prevCls: {
					value: i + "pb-prev"
				},
				nextText: {
					value: "\u4e0b\u4e00\u9875"
				},
				nextCls: {
					value: i + "pb-next"
				},
				lastText: {
					value: "\u672b \u9875"
				},
				lastCls: {
					value: i + "pb-last"
				},
				skipText: {
					value: "\u786e\u5b9a"
				},
				skipCls: {
					value: i + "pb-skip"
				},
				totalPageTpl: {
					value: "\u5171 {totalPage} \u9875"
				},
				curPageTpl: {
					value: '\u7b2c <input type="text" autocomplete="off" class="' + i + 'pb-page" size="20" name="inputItem"> \u9875'
				},
				totalCountTpl: {
					value: "\u5171{totalCount}\u6761\u8bb0\u5f55"
				},
				curPage: {
					value: 0
				},
				totalPage: {
					value: 0
				},
				totalCount: {
					value: 0
				},
				pageSize: {
					value: 30
				},
				store: {}
			},
			ID_FIRST: s,
			ID_PREV: o,
			ID_NEXT: u,
			ID_LAST: a,
			ID_SKIP: f,
			ID_TOTAL_PAGE: l,
			ID_CURRENT_PAGE: c,
			ID_TOTAL_COUNT: h
		}, {
			xclass: "pagingbar",
			priority: 2
		});
	return p
}), define("bui/toolbar/numberpagingbar", ["bui/toolbar/pagingbar"], function(e) {
	var t = BUI.Component,
		n = e("bui/toolbar/pagingbar"),
		r = BUI.prefix,
		i = "numberContainer",
		s = r + "button-number",
		o = n.extend({
			_getItems: function() {
				var e = this,
					t = e.get("items");
				return t ? t : (t = [], t.push(e._getButtonItem(n.ID_PREV)), t.push(e._getButtonItem(n.ID_NEXT)), t)
			},
			_getButtonItem: function(e) {
				var t = this;
				return {
					id: e,
					content: '<a href="javascript:;">' + t.get(e + "Text") + "</a>",
					disabled: !0
				}
			},
			_bindButtonEvent: function() {
				var e = this,
					t = e.get("numberButtonCls");
				e.constructor.superclass._bindButtonEvent.call(this), e.get("el").delegate("a", "click", function(e) {
					e.preventDefault()
				}), e.on("click", function(n) {
					var r = n.target;
					if (r && r.get("el").hasClass(t)) {
						var i = r.get("id");
						e.jumpToPage(i)
					}
				})
			},
			_setNumberPages: function() {
				var e = this;
				e._setNumberButtons()
			},
			_setNumberButtons: function() {
				var e = this,
					t = e.get("curPage"),
					n = e.get("totalPage"),
					r = e._getNumberItems(t, n),
					i;
				e._clearNumberButtons(), BUI.each(r, function(t) {
					e._appendNumberButton(t)
				}), i = e.getItem(t), i && i.set("selected", !0)
			},
			_appendNumberButton: function(e) {
				var t = this,
					n = t.getItemCount(),
					r = t.addItemAt(e, n - 1)
			},
			_clearNumberButtons: function() {
				var e = this,
					t = e.getItems(),
					n = e.getItemCount();
				while (n > 2) e.removeItemAt(n - 2), n = e.getItemCount()
			},
			_getNumberItems: function(e, t) {
				function u(e, t) {
					for (var i = e; i <= t; i++) r.push(n._getNumberItem(i))
				}

				function a() {
					r.push(n._getEllipsisItem())
				}
				var n = this,
					r = [],
					i = n.get("maxLimitCount"),
					s = n.get("showRangeCount"),
					o;
				if (t < i) o = t, u(1, t);
				else {
					var f = e <= i ? 1 : e - s,
						l = e + s,
						c = l < t ? l > i ? l : i : t;
					f > 1 && (u(1, 1), f > 2 && a()), o = c, u(f, c)
				}
				return o < t && (o < t - 1 && a(), u(t, t)), r
			},
			_getEllipsisItem: function() {
				var e = this;
				return {
					disabled: !0,
					content: e.get("ellipsisTpl")
				}
			},
			_getNumberItem: function(e) {
				var t = this;
				return {
					id: e,
					elCls: t.get("numberButtonCls")
				}
			}
		}, {
			ATTRS: {
				itemStatusCls: {
					value: {
						selected: "active",
						disabled: "disabled"
					}
				},
				itemTpl: {
					value: '<a href="">{id}</a>'
				},
				prevText: {
					value: "<<"
				},
				nextText: {
					value: ">>"
				},
				maxLimitCount: {
					value: 4
				},
				showRangeCount: {
					value: 1
				},
				numberButtonCls: {
					value: s
				},
				ellipsisTpl: {
					value: '<a href="#">...</a>'
				}
			}
		}, {
			xclass: "pagingbar-number",
			priority: 3
		});
	return o
});