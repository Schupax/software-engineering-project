package model.gamelogic;

public enum EBiddingOptions {
	Yes, No, Bidding;

	private int _biddingValue = 0;

	public final void setBiddingValue(int pBiddingValue) throws Exception {
		if (EBiddingOptions.Bidding.equals(this)) {
			_biddingValue = pBiddingValue;
		}else{
			throw new Exception();
		}
	}

	public int getBiddingValue() {
		return _biddingValue;
	}
}
