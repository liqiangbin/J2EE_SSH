BUI.use(["bui/menu", "bui/tab"], function(h, l) {
	var k = BUI.app("PageUtil");
	var p = "dl-selected",
		c = "ks-hidden",
		y = "dl-last",
		x = "dl-hover",
		n = "nav-item",
		s = "dl-second-slib",
		f = "dl-tab-item",
		t = "dl-collapse",
		v = "dl-hide-current",
		u = "data-index",
		j = 145;

	function g(z) {
		window.topManager = z
	}

	function b(z, A) {
		if (z.indexOf("?") !== -1) {
			return z + "&" + A
		} else {
			return z + "?" + A
		}
	}

	function i(B, E, H, F, A) {
		var I = this,
			C = new h.SideMenu(H),
			D = new l.NavTab(E),
			J = $(H.render),
			z = J.next("." + s + "-con"),
			G = J.parents("." + f);
		if (z) {
			z.on("click", function() {
				G.toggleClass(t)
			});
			z.parent().height(E.height)
		}
		if (F) {
			G.addClass(t)
		}
		C.on("menuclick", function(L) {
			var K = L.item;
			if (K) {
				I.tab.addTab({
					id: K.get("id"),
					title: K.get("text"),
					href: K.get("href"),
					closeable: K.get("closeable")
				}, true)
			}
		});
		C.on("itemselected", function(L) {
			var K = L.item;
			if (K) {
				e(B, K.get("id"))
			}
		});
		D.on("activeChange", function(L) {
			var K = L.item;
			if (K) {
				I.menu.setSelectedByField(K.get("id"))
			} else {
				I.menu.clearSelection()
			}
		});
		I.tab = D;
		I.menu = C;
		I.homePage = A;
		D.render();
		C.render()
	}

	function e(A, z) {
		z = z || "";
		var B = "#" + A;
		if (z) {
			B += "/" + z
		}
		location.hash = B
	}

	function d() {
		var D = location.hash,
			C = 0,
			z = "",
			A = D.indexOf("/"),
			B = null;
		if (!D) {
			return null
		}
		if (A >= 0) {
			C = D.substring(1, A);
			z = D.substring(A + 1);
			B = r(z);
			if (B) {
				z = z.replace("?" + B, "")
			}
		} else {
			C = D.substring(1)
		}
		return {
			moduleId: C,
			pageId: z,
			search: B
		}
	}

	function r(z) {
		var A = z.indexOf("?");
		if (A >= 0) {
			return z.substring(A + 1)
		}
		return null
	}

	function m(z) {
		if (!$.isArray(z)) {
			return
		}
		var A = q(z);
		while (A !== -1) {
			z.splice(A, 1);
			A = q(z)
		}
		return z
	}

	function q(A) {
		var z = -1;
		$.each(A, function(B, C) {
			if (C === null || C === undefined) {
				z = B;
				return false
			}
		});
		return z
	}

	function a() {
		var z = BUI.viewportHeight(),
			A = 70;
		return z - A
	}

	function o(z) {
		var A = $(z);
		if (A.hasClass(n)) {
			return z
		}
		return A.parent("." + n)[0]
	}
	var w = function(z) {
		m(z);
		w.superclass.constructor.call(this, z);
		this._init();
		g(this)
	};
	w.ATTRS = {
		currentModelIndex: {},
		hideItmes: {
			value: []
		},
		hideList: {},
		modules: {
			value: []
		},
		modulesConfig: {},
		navList: {
			valueFn: function() {
				return $("#J_Nav")
			}
		},
		navContent: {
			valueFn: function() {
				return $("#J_NavContent")
			}
		},
		navItems: {
			valueFn: function() {
				return $("#J_Nav").children("." + n)
			}
		},
		navTabs: {
			valueFn: function() {
				return this.get("navContent").children("." + f)
			}
		},
		urlSuffix: {
			value: ".html"
		}
	};
	BUI.extend(w, BUI.Base);
	BUI.augment(w, {
		openPage: function(O) {
			var J = this,
				E = O.moduleId || J._getCurrentModuleId(),
				C = O.id,
				L = O.title || "\u65b0\u7684\u6807\u7b7e\u9875",
				B = O.href,
				N = O.isClose,
				D = O.closeable,
				A = O.reload,
				P = O.search;
			var G = J._getModule(E);
			if (G) {
				var H = G.tab,
					F = G.menu,
					z = F.getItem(C),
					K = H.getActivedItem(),
					M = K ? K.get("id") : null,
					I = J._getModuleIndex(E);
				if (E != J._getCurrentModuleId()) {
					J._setModuleSelected(I)
				}
				if (z) {
					J._setPageSelected(I, C, A, P)
				} else {
					H.addTab({
						id: C,
						title: L,
						href: B,
						sourceId: M,
						closeable: D
					}, A)
				} if (N) {
					K.close()
				}
			}
		},
		closePage: function(A, z) {
			this.operatePage(z, A, "close")
		},
		reloadPage: function(A, z) {
			this.operatePage(z, A, "reload")
		},
		setPageTitle: function(A, B, z) {
			this.operatePage(z, B, "setTitle", [A])
		},
		operatePage: function(E, G, F, A) {
			E = E || this._getCurrentModuleId();
			A = A || [];
			var z = this,
				B = z._getModule(E);
			if (B) {
				var C = B.tab,
					D = G ? C.getItemById(G) : C.getActivedItem();
				if (D && D[F]) {
					D[F].apply(D, A)
				}
			}
		},
		_createModule: function(E) {
			var z = this,
				C = z._getModuleConfig(E),
				B = z.get("modules");
			if (!C) {
				return null
			}
			var E = C.id,
				A = "#J_" + E + "Tab",
				D = "#J_" + E + "Tree";
			module = new i(E, {
				render: A,
				height: a() - 5
			}, {
				render: D,
				items: C.menu,
				height: a() - 5
			}, C.collapsed, C.homePage);
			B[E] = module;
			return module
		},
		_hideHideList: function() {
			this.get("hideList").hide()
		},
		_init: function() {
			var z = this;
			z._initDom();
			z._initNavItems();
			z._initEvent()
		},
		_initNavItems: function() {
			var I = this,
				C = I.get("navItems"),
				B = I.get("hideItmes");
			if (C.length === 0) {
				return
			}
			$('<div class="nav-item-mask"></div>').appendTo($(C));
			var G = C.length,
				K = BUI.viewportWidth(),
				H = j,
				F = H * G,
				z = 0;
			if (F <= K) {
				return
			}
			$.each(C, function(L, M) {
				$(M).attr(u, L);
				$(M).removeClass(y)
			});
			z = parseInt(K / H);
			var A = C[z - 1];
			I._setLastItem(A);
			B.push($(A).clone()[0]);
			for (var E = z; E < G; E++) {
				var J = $(C[E]),
					D = null;
				D = J.clone()[0];
				B.push(D);
				J.addClass(c)
			}
			I._initHideList()
		},
		_initHideList: function() {
			var B = this,
				A = B.get("hideList"),
				z = B.get("hideItmes");
			if (A) {
				return
			}
			var D = '<ul class="dl-hide-list ks-hidden"></ul>',
				C = $(D).appendTo("body");
			A = C;
			$.each(z, function(E, F) {
				$(F).appendTo(A)
			});
			B.set("hideList", A);
			B._initHideListEvent()
		},
		_initHideListEvent: function() {
			var A = this,
				z = A.get("hideList");
			if (z == null) {
				return
			}
			z.on("mouseleave", function() {
				A._hideHideList()
			});
			z.on("click", function(E) {
				var D = o(E.target),
					C = null,
					B = 0;
				if (D) {
					C = $(D);
					B = C.attr(u);
					A._setModuleSelected(B);
					A._hideHideList()
				}
			})
		},
		_initContents: function() {
			var z = this,
				B = z.get("modulesConfig"),
				A = z.get("navContent");
			A.children().remove();
			$.each(B, function(D, E) {
				var F = E.id,
					C = ['<li class="dl-tab-item ks-hidden"><div class="dl-second-nav"><div class="dl-second-tree" id="J_', F, 'Tree"></div><div class="', s, '-con"><div class="', s, '"></div></div></div><div class="dl-inner-tab" id="J_', F, 'Tab"></div></li>'].join("");
				new $(C).appendTo(A)
			})
		},
		_initDom: function() {
			var z = this;
			z._initContents();
			z._initLocation()
		},
		_initEvent: function() {
			var z = this,
				A = z.get("navItems");
			A.each(function(B, C) {
				var C = $(C);
				C.on("click", function() {
					var D = $(this);
					if (D.hasClass(p)) {
						return
					}
					z._setModuleSelected(B, D)
				}).on("mouseenter", function() {
					$(this).addClass(x)
				}).on("mouseleave", function() {
					$(this).removeClass(x)
				})
			});
			z._initNavListEvent()
		},
		_initNavListEvent: function() {
			var A = this,
				z = A.get("hideList"),
				B = A.get("navList");
			B.on("mouseover", function(E) {
				var D = o(E.target),
					C = $(D),
					F = null;
				if (C && C.hasClass(y) && z) {
					F = C.offset();
					F.top += 37;
					F.left += 2;
					A._showHideList(F)
				}
			}).on("mouseout", function(D) {
				var C = D.toElement;
				if (C && z && !$.contains(z[0], C) && C !== z[0]) {
					A._hideHideList()
				}
			})
		},
		_initLocation: function() {
			var z = this,
				D = d();
			if (D) {
				var B = D.pageId,
					E = D.search,
					C = z._getModuleIndex(D.moduleId);
				z._setModuleSelected(C);
				z._setPageSelected(C, B, true, E)
			} else {
				var A = z.get("currentModelIndex"),
					F = z._getModuleId(A);
				if (A == null) {
					z._setModuleSelected(0)
				} else {
					e(F)
				}
			}
		},
		_getModule: function(B) {
			var z = this,
				A = z.get("modules")[B];
			if (!A) {
				A = z._createModule(B)
			}
			return A
		},
		_getModuleIndex: function(B) {
			var A = this,
				z = 0;
			$.each(A.get("modulesConfig"), function(D, C) {
				if (C.id === B) {
					z = D;
					return false
				}
			});
			return z
		},
		_getModuleConfig: function(B) {
			var A = this,
				z = null;
			$.each(A.get("modulesConfig"), function(D, C) {
				if (C.id === B) {
					z = C;
					return false
				}
			});
			return z
		},
		_getModuleId: function(z) {
			var A = this.get("modulesConfig");
			if (A[z]) {
				return A[z].id
			} else {
				return z
			}
		},
		_getCurrentPageId: function() {
			var z = this,
				D = z._getCurrentModuleId(),
				B = z._getModule(D),
				A = "";
			if (B) {
				var C = B.menu.getSelected();
				if (C) {
					A = C.get("id")
				}
			}
			return A
		},
		_getCurrentModuleId: function() {
			return this._getModuleId(this.get("currentModelIndex"))
		},
		_isModuleInitial: function(z) {
			return !!this.get("modules")[z]
		},
		_setLastItem: function(D) {
			var z = this,
				A = z.get("lastShowItem");
			if (A === D) {
				return
			}
			var B = null,
				C = $(A);
			itemEl = $(D);
			if (A) {
				B = C.find("." + v);
				C.removeClass(y);
				C.addClass(c)
			}
			itemEl.addClass(y);
			itemEl.removeClass(c);
			if (!B) {
				B = $('<span class="icon icon-white  icon-caret-down ' + v + '">&nbsp;&nbsp;</span>')
			}
			B.appendTo(itemEl.children(".nav-item-inner"));
			z.set("lastShowItem", D)
		},
		_setModuleSelected: function(F, E) {
			var H = this,
				D = H.get("navItems"),
				B = H.get("navTabs"),
				G = H.get("currentModelIndex");
			if (G !== F) {
				var z = H._getModuleId(F),
					A = null,
					C = H.get("lastShowItem"),
					I = true;
				if (!H._isModuleInitial(z)) {
					I = false
				}
				A = H._getModule(z);
				E = E || $(H.get("navItems")[F]);
				if (E.hasClass(c) && C) {
					H._setLastItem(E[0]);
					H._setSelectHideItem(F)
				}
				D.removeClass(p);
				E.addClass(p);
				B.addClass(c);
				$(B[F]).removeClass(c);
				G = F;
				H.set("currentModelIndex", G);
				curPageId = H._getCurrentPageId();
				e(z, curPageId);
				if (!curPageId && A.homePage) {
					H._setPageSelected(F, A.homePage)
				}
			}
		},
		_setPageSelected: function(E, F, G, K) {
			var H = this,
				B = H._getModuleId(E) || E,
				C = H._getModule(B);
			if (C && F) {
				C.menu.setSelectedByField(F);
				var J = C.menu.getSelected(),
					D = C.tab,
					A = "",
					z = -1;
				if (J && J.get("id") === F) {
					A = J.get("href");
					A = K ? (b(A, K)) : A;
					C.tab.addTab({
						id: J.get("id"),
						title: J.get("text"),
						closeable: J.get("closeable"),
						href: A
					}, !!G)
				} else {
					if (F) {
						var I = F.replace("-", "/");
						if (I.indexOf("/") === -1) {
							I = B + "/" + I
						}
						if ((z = F.indexOf(".")) === -1) {
							I += H.get("urlSuffix")
						}
						A = K ? (I + "?" + K) : I;
						D.addTab({
							id: F,
							title: "",
							href: A
						}, !!G)
					}
				}
			}
		},
		_showHideList: function(B) {
			var A = this,
				z = A.get("hideList");
			z.css("left", B.left);
			z.css("top", B.top);
			z.show()
		},
		_setSelectHideItem: function(D) {
			var B = this,
				A = B.get("hideList"),
				z = B.get("hideItmes"),
				E = null,
				C = null,
				G = null,
				F = null;
			BUI.each(z, function(I) {
				var H = $(I);
				if (H.attr(u) == D) {
					C = I
				}
				if (H.hasClass(y)) {
					E = I
				}
			});
			if (E !== C) {
				if (E) {
					F = $(E).find(".dl-hide-current");
					$(E).removeClass(y)
				}
				$(C).addClass(y);
				if (!F) {
					F = new Node('<span class="dl-hide-current">&nbsp;&nbsp;</span>')
				}
				G = $(C);
				F.appendTo(G.children(".nav-item-inner"));
				G.prependTo(A)
			}
		}
	});
	k.MainPage = w
});