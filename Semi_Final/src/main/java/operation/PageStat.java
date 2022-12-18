package operation;

public class PageStat{
	String findDate="";
	String findMachine_no="";
	String findManager="";
	String findPrname="";
	String findStatus="";
	String findUpdate_time="";
	

	public String getFindStatus() {
		return findStatus;
	}

	public void setFindStatus(String findStatus) {
		this.findStatus = findStatus;
	}

	public String getFindUpdate_time() {
		return findUpdate_time;
	}

	public void setFindUpdate_time(String findUpdate_time) {
		this.findUpdate_time = findUpdate_time;
	}

	String findPrcode="";
	int nowPage=1;
	
	int totSize;
	int listSize = totSize;
	int blockSize = 5;
	
	int totPage, startPage, endPage;
	int startNo, endNo;	
	
	public void setData(int nowPage, int totSize) {
		this.nowPage = nowPage;
		this.totPage = totSize;
		compute();
	}
	
	public void compute() {
		totPage = (int)Math.ceil((double)totSize/listSize);
		endPage = (int)Math.ceil((double)nowPage/blockSize)*blockSize;
		startPage = endPage - blockSize +1;	
		if(endPage>totPage) endPage = totPage;
		
		endNo = nowPage*listSize;
		startNo = endNo - listSize;		//mysql에서는 +1을 하지 않음. 0부터 시작한다. 오라클은 +1을 해야합니다. mysql limit 속성이 zero베이스이기 때문이다.
		if(endNo>totSize) endNo = totSize;
	}
	
	public int getTotSize() {
		return totSize;
	}
	public void setTotSize(int totSize) {
		this.totSize = totSize;
	}
	public int getListSize() {
		return listSize;
	}
	public void setListSize(int listSize) {
		this.listSize = listSize;
	}
	public int getBlockSize() {
		return blockSize;
	}
	public void setBlockSize(int blockSize) {
		this.blockSize = blockSize;
	}
	public int getTotPage() {
		return totPage;
	}
	public void setTotPage(int totPage) {
		this.totPage = totPage;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public int getStartNo() {
		return startNo;
	}
	public void setStartNo(int startNo) {
		this.startNo = startNo;
	}
	public int getEndNo() {
		return endNo;
	}
	public void setEndNo(int endNo) {
		this.endNo = endNo;
	}
	
	public String getFindPrcode() {
		return findPrcode;
	}
	public void setFindPrcode(String findPrcode) {
		this.findPrcode = findPrcode;
	}
	public int getNowPage() {
		return nowPage;
	}
	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}
	public String getFindDate() {
		return findDate;
	}

	public String getFindMachine_no() {
		return findMachine_no;
	}

	public String getFindManager() {
		return findManager;
	}

	public String getFindPrname() {
		return findPrname;
	}

	public void setFindDate(String findDate) {
		this.findDate = findDate;
	}

	public void setFindMachine_no(String findMachine_no) {
		this.findMachine_no = findMachine_no;
	}

	public void setFindManager(String findManager) {
		this.findManager = findManager;
	}

	public void setFindPrname(String findPrname) {
		this.findPrname = findPrname;
	}
}
