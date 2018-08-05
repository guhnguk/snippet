package patterns;

public class BuilderPattern {
	// example file name
	// 2012_10_23_CA_houry_37.8,-122.4.csv

	public final static String hourlyFix = "hourly";
	public final static String summaryFix = "summary";

	private boolean isSummary;
	private String hourlyInfo;
	private String summaryInfo;
	private String dateTime;
	private String state;
	private String queryLatLon;

	public static class Build {
		private boolean isSummary;
		private String hourlyInfo;
		private String summaryInfo;
		private String dateTime;
		private String state;
		private String queryLatLon;

		public Build isSummary(boolean isSummary) {
			this.isSummary = isSummary;
			return this;
		}

		public Build hourlyInfo(String hourlyInfo) {
			this.hourlyInfo = hourlyInfo;
			return this;
		}

		public Build summaryInfo(String summaryInfo) {
			this.summaryInfo = summaryInfo;
			return this;
		}

		public Build dateTime(String dateTime) {
			this.dateTime = dateTime;
			return this;
		}

		public Build state(String state) {
			this.state = state;
			return this;
		}

		public Build queryLatLon(String queryLatLon) {
			this.queryLatLon = queryLatLon;
			return this;
		}
		
		public BuilderPattern build() {
			return new BuilderPattern(this);
		}
	}

	private BuilderPattern(Build build) {
		this.isSummary = build.isSummary;
		this.hourlyInfo = build.hourlyInfo;
		this.summaryInfo = build.summaryInfo;
		this.dateTime = build.dateTime;
		this.state = build.state;
		this.queryLatLon = build.queryLatLon;
	}
}
