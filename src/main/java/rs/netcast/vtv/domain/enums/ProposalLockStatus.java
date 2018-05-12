package rs.netcast.vtv.domain.enums;

public enum ProposalLockStatus {
	UNLOCKED(0),
	LOCKED(1);
	
	private int status;

	private ProposalLockStatus(int status) {
		this.status = status;
	}

	public int getStatus() {
		return status;
	}

}
