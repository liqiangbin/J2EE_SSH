package shiep.service;

import shiep.bean.PageBean;

public interface CustomerService {
    //ʡ�������Ĵ���

    /**
     * ��ҳ��ѯ
     * @param currentPage ��ǰ�ڼ�ҳ
     * @param pageSize ÿҳ��С
     * @return ����˷�ҳ��Ϣ(������¼��list)��Bean
     */
    public PageBean queryForPage(int pageSize,int currentPage);

}