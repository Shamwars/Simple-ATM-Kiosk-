public class Video{
	private String  title;
	private int     serial;
	private double  cost;
	
	public Video(String title, int serial, double cost)
	{
		this.title  = title;
		this.serial = serial;
		this.cost   = cost;
	}

	public String getTitle()  {return title;}
    public int    getSerial() {return serial;}
    public double  getCost()   {return cost;}

	
	public String getVideo() {
    return "title:" + title + " Serial: " + serial + " Cost: " + cost;
  }
	//	Upgrade output of toString ()
	
	@Override
	public String toString() {
		return "["+getVideo()+"]";
  }
}

