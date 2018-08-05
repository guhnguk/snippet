package daemon.parser;

public final class ETLConstants {

	public static final String CONFIG_PROPERTIES = "config.properties";

	// config file properties
	public static final String SOURCE_FILE_PATH = "source.file.path";
	public static final String SOURCE_FILE_START = "source.file.start";
	public static final String SOURCE_FILE_END = "source.file.end";
	public static final String SOURCE_FILE_EXCLUDE_HOURS = "source.file.exclude.hours";
	public static final String SOURCE_FILE_INCLUDE_HOURS = "source.file.include.hours";

	public static final String TARGET_FILE_SIZE_UNIT = "target.file.size.unit";
	public static final String TARGET_FILE_PATH = "target.file.path";
	
	public static final String KB = "KB";
	public static final String MB = "MB";
	public static final String GB = "GB";
	public static final String TB = "TB";
	public static final String PB = "PB";
	public static final String ZB = "ZB";

	public static final long KByte = 1024L;// 킬로 바이트
	public static final long MByte = KByte * KByte;// 메가 바이트
	public static final long GByte = MByte * MByte;// 기가 바이트
	public static final long TByte = GByte * GByte;// 테라 바이트
	public static final long PByte = TByte * TByte;// 페타 바이트
	public static final long ZByte = PByte * PByte;// 제타 바이트

	// public static final String SOURCE_FILE_TYPE = "source.file.type";
	// public static final String SOURCE_FILE_PATH = "source.file.path";
	// public static final String SOURCE_THREAD_COUNT = "source.thread.count";
	//
	// public static final String TARGET_FILE_PATH = "target.file.path";
	//
	// public static final String TARGET_DB_TABLE = "target.db.table";
	// public static final String TARGET_DB_PASSWORD = "target.db.password";
	// public static final String TARGET_DB_USERNAME = "target.db.username";
	// public static final String TARGET_DB_NAME = "target.db.name";
	// public static final String TARGET_DB_SERVER = "target.db.server";
	// public static final String TARGET_DB_DRIVER = "target.db.driver";
	// public static final String TARGET_DB_SCHEMA = "target.db.schema";
	//
	// public static final String TARGET_DB_MAX_ACTIVE = "target.db.maxactive";
	// public static final String TARGET_DB_MAX_IDLE = "target.db.maxidle";
	// public static final String TARGET_DB_MAX_WAIT = "target.db.maxwait";
	// public static final String TARGET_DB_READONLY = "target.db.readonly";
	// public static final String TARGET_DB_AUTOCOMMIT = "target.db.autocommit";

}
