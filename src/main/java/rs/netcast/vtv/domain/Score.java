package rs.netcast.vtv.domain;

public class Score {
	private int total;
	private int first;
	private int high;
	private int prestige;
	private int skyline;
	
	public Score(int total, int first, int high, int prestige, int skyline) {
		super();
		this.total = total;
		this.first = first;
		this.high = high;
		this.prestige = prestige;
		this.skyline = skyline;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getFirst() {
		return first;
	}
	public void setFirst(int first) {
		this.first = first;
	}
	public int getHigh() {
		return high;
	}
	public void setHigh(int high) {
		this.high = high;
	}
	public int getPrestige() {
		return prestige;
	}
	public void setPrestige(int prestige) {
		this.prestige = prestige;
	}
	public int getSkyline() {
		return skyline;
	}
	public void setSkyline(int skyline) {
		this.skyline = skyline;
	}
	
}
