package member;

public class MybatisPageVo {
    String findStr =""; // 검색어
    int nowPage =1;     // 현재 페이지
    int totSize;        // 전체 검색 건수(데이터 수)
    int listSize=20;    // 한 페이지에 표시 될 목록수
    int blockSize=5;    // 한 화면에 표시되는 페이지 수
    int totPage,startPage,endPage;  // 전체 페이지 수 / 현재 표시되는 페이지 중 처음 / 현재 표시되는 페이지 중 마지막
    int startNo, endNo;     // 현재 페이지에 표시 된 첫 번째 데이터 / 현재 페이지에 표시 된 마지막 데이터
    
    
    public void setData(int nowPage, int totSize) {
        this.nowPage = nowPage;
        this.totSize = totSize;
        compute();
    }
    
    public void compute() {
        totPage = (int)Math.ceil((double)totSize/listSize);
        endPage = (int)Math.ceil((double)nowPage/blockSize)*blockSize;
        startPage = endPage-blockSize + 1;   
        if(endPage>totPage) endPage=totPage;
        
        endNo = nowPage*listSize;           //현재 페이지에 나타나는 마지막 데이터
        startNo = endNo-listSize;           //현재 페이지에 나타나는 첫 번째 데이터 mysql에서는 +1을 하지 않는다(1베이스). (다른 db에서는 +1을 해야한다 / 0베이스)
        if(endNo>totSize) endNo=totSize;    // 보정작업은 마지막에 해야한다.
    }
    
    public String getFindStr() {
        return findStr;
    }
    public int getNowPage() {
        return nowPage;
    }
    public int getTotSize() {
        return totSize;
    }
    public int getListSize() {
        return listSize;
    }
    public int getBlockSize() {
        return blockSize;
    }
    public int getTotPage() {
        return totPage;
    }
    public int getStartPage() {
        return startPage;
    }
    public int getEndPage() {
        return endPage;
    }
    public int getStartNo() {
        return startNo;
    }
    public int getEndNo() {
        return endNo;
    }
    public void setFindStr(String findStr) {
        this.findStr = findStr;
    }
    public void setNowPage(int nowPage) {
        this.nowPage = nowPage;
    }
    public void setTotSize(int totSize) {
        this.totSize = totSize;
    }
    public void setListSize(int listSize) {
        this.listSize = listSize;
    }
    public void setBlockSize(int blockSize) {
        this.blockSize = blockSize;
    }
    public void setTotPage(int totPage) {
        this.totPage = totPage;
    }
    public void setStartPage(int startPage) {
        this.startPage = startPage;
    }
    public void setEndPage(int endPage) {
        this.endPage = endPage;
    }
    public void setStartNo(int startNo) {
        this.startNo = startNo;
    }
    public void setEndNo(int endNo) {
        this.endNo = endNo;
    }
}
