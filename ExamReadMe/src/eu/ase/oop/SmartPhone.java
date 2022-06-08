package eu.ase.oop;

public class SmartPhone extends Phone  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int batteryDuration;

	
	
	@Override
	public String infoDevice() {
		// TODO Auto-generated method stub
		String mama=new String();
		mama+=this.batteryDuration;
		return mama;
	}

	public int getBatteryDuration() {
		return batteryDuration;
	}

	public void setBatteryDuration(int batteryDuration) throws Exception {
		if (batteryDuration<=0)
			throw new Exception("Battery duration lower than 0");
		else
		{
			this.batteryDuration = batteryDuration;
		}
		
	}
	
	
	
	
	
}
