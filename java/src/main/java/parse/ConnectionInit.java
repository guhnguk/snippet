package parse;

public class ConnectionInit {
	private String ConnInit = "028§was-eu-1§28/Feb/2013:16:42:40+0900§ConnectionInit§703dc025eb57c6d861b78de7a9b7aa5d§0006820lna§KOR§dt=asdf1234¶peerip=192.168.100.1¶min=";
	
	public static void main(String[] args) {
		new ConnectionInit().execute();
	}
	
	private void execute() {
		String[] split = ConnInit.split("\\xa7");
		for (String s: split) {
			System.out.println(s);
		}
		
		String[] string = split[split.length-1].split("\\xb6");
		for (String s: string) {
			System.out.println(s);
		}
	}
}
