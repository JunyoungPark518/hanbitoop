package array;

public class ArrayServiceImpl implements ArrayService {
	String[] arr;
	int len;
	public ArrayServiceImpl() {
		arr = new String[5];
		len = 0;
	}
	
	@Override
	public String add() {
		arr[0] = "Java";
		arr[1] = "JSP";
		arr[2] = "Spring";
		arr[3] = "JS";
		arr[4] = "HTML";
		len = arr.length;
		return "원소가 추가되었습니다.";
	}

	@Override
	public String findOne(char keyword) {
		String msg = "";
		for(int i=0; i<len; i++) {
			if(keyword==arr[i].charAt(0)) {
				msg = String.format("%d번째의 원소가 '%c'로 시작합니다. [%s]", i+1, keyword, arr[i]);
				break;
			} else {
				msg = String.format("'%c'로 시작하는 원소가 없습니다.", keyword);
			}
		}
		return msg;
	}

	@Override
	public String findSome(char keyword) {
		String msg = "";
		for(int i=0; i<len; i++) {
			if(keyword==arr[i].charAt(0)) {
				msg+=String.format("%d번째의 원소가 '%c'로 시작합니다. [%s]\n", i+1, keyword, arr[i]);
			} 
		}
		if(msg.equals(null)) {
			msg = "검색한 결과가 없습니다.";
		}
		return msg;
	}

	@Override
	public String list() {
		String msg = "전체 리스트는 \n";
		for(int i=0; i<len; i++) {
			msg += arr[i] + "\t";
		}
		msg += "\n입니다.";
		return msg;
	}

	@Override
	public String update(String before, String after) {
		String msg = "";
		for(int i=0; i<len; i++) {
			if(before.equals(arr[i])) {
				msg = String.format("%s 원소가 %s로 변경되었습니다.", before, after);
				arr[i] = after;
				break;
			} else {
				msg = "찾을 수 없습니다.";
			}
		}
		msg += "\n현재 존재하는 원소는 \n";
		for(int i=0; i<len; i++) {
			msg += arr[i] + "\t";
		}
		msg += "\n입니다.";
		return msg;
	}

	@Override
	public String delete(String delete) {
		String msg = "";
		for(int i=0; i<len; i++) {
			if(delete.equals(arr[i])) {
				msg = String.format("%s 원소가 제거되었습니다.\n", arr[i]);
				arr[i] = arr[len-1];
				arr[len-1] = null;
				len--;
			} else {
				msg = "찾을 수 없습니다.";
			}
		}
		msg += "현재 존재하는 원소는 \n";
		for(int i=0; i<len; i++) {
			msg += arr[i] + "\t";
		}
		msg += "\n입니다.";
		return msg;
	}

}
