package br.edu.ifba.ads.inf008.monitoring.entities;

public abstract class Unity implements UnityIF {
	private String id;
	private boolean videoCamera;
	private boolean thermomether;
	private boolean co2;
	private boolean ch4;
	private boolean available;
	private Point point;

	public Unity(String id, float latitude, float longitude, boolean videoCamera, boolean thermomether, boolean co2,
			boolean ch4) {
		this.setId(id);
		this.setVideoCamera(videoCamera);
		this.setThermomether(thermomether);
		this.setCo2(co2);
		this.setCh4(ch4);
		this.setAvailable(true);
		this.setPoint(latitude, longitude);
	}

	public boolean hasConfiguration(boolean videoCamera, boolean thermomether, boolean co2, boolean ch4) {
		if (this.isVideoCamera() == videoCamera && this.isThermomether() == thermomether && this.isCo2() == co2
				&& this.ch4 == ch4 && this.isAvailable()) {
			return true;
		}
		return false;
	}
	

	public String getId() {
		return id;
	}

	public boolean isVideoCamera() {
		return videoCamera;
	}

	public boolean isThermomether() {
		return thermomether;
	}

	public boolean isCo2() {
		return co2;
	}

	public boolean isCh4() {
		return ch4;
	}

	public boolean isAvailable() {
		return this.available;
	}

	public Point getPoint() {
		return point;
	}

	protected void setId(String id) {
		this.id = id;
	}

	protected void setVideoCamera(boolean videoCamera) {
		this.videoCamera = videoCamera;
	}

	protected void setThermomether(boolean thermomether) {
		this.thermomether = thermomether;
	}

	protected void setCo2(boolean co2) {
		this.co2 = co2;
	}

	protected void setCh4(boolean ch4) {
		this.ch4 = ch4;
	}

	protected void setAvailable(boolean available) {
		this.available = available;
	}

	protected void setPoint(float latitude, float longitude) {
		this.point = new Point(latitude, longitude);
	}

}
