package deserialization;

import java.util.List;

public class api_response {
	
	private int page;
    private int per_page;
    private int total;
    private int total_pages;
    private List<de_user> data;
    private support Support;
    
    
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPer_page() {
		return per_page;
	}
	public void setPer_page(int per_page) {
		this.per_page = per_page;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getTotal_pages() {
		return total_pages;
	}
	public void setTotal_pages(int total_pages) {
		this.total_pages = total_pages;
	}
	public List<de_user> getData() {
		return data;
	}
	public void setData(List<de_user> data) {
		this.data = data;
	}
	public support getSupport() {
		return Support;
	}
	public void setSupport(support support) {
		Support = support;
	}
	
	
    
    
    
    

}
