import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// threeSum(new int[] {-1,0,1,2,-1,-4});
		threeSum(new int[] { -4, -2, 1, -5, -4, -4, 4, -2, 0, 4, 0, -2, 3, 1, -5, 0 });
	}

	public static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> rt = new ArrayList<List<Integer>>();

		if (nums.length < 3)
			return rt;
		Arrays.sort(nums);
		List<Map<Integer, Integer>> twoMapList = new ArrayList<Map<Integer, Integer>>();
		for (int i = 0; i < nums.length - 1; i++) {
			Map<Integer, Integer> twoMap = new HashMap<Integer, Integer>();
			twoMapList.add(twoMap);
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			for (int j = i + 1; j < nums.length; j++) {
				boolean addFlag = true;
				// for (Map<Integer, Integer> index : twoMapList) {

				if (addFlag && !twoMap.containsKey((nums[i] + nums[j]))) {
					twoMap.put((nums[i] + nums[j]), j);
					System.out.println("[x,y]-" + "[" + nums[i] + "," + nums[j] + "]- value: " + (nums[i] + nums[j]));
				}
			}
			// System.out.println("-------------------------------------------------s");
			
		}

		for (int j = 0; j < twoMapList.size(); j++) {
			Map<Integer, Integer> map = twoMapList.get(j);
			// for (Map.Entry<Integer, Integer> entry : map.entrySet())
			for (int i = j + 1; i < nums.length; i++) {

				if (map.containsKey((-1 * nums[i]))) {
					int secIndx = map.get((-1 * nums[i]));
					
					if (secIndx < i) {

						boolean addFlag = true;
						for (List<Integer> index : rt) {
							if (index.get(0) == (nums[j]) && index.get(2) == (nums[i])
									&& index.get(1) == (nums[secIndx])) {
								addFlag = false;
								break;
							}
						}
						if (addFlag) {
							List<Integer> list = new ArrayList<Integer>();
							list.add(nums[j]);
							list.add(nums[secIndx]);
							list.add(nums[i]);

							rt.add(list);
							// System.out.println("[x,y,z]-"+"["+i+","+j+","+secInd+"]");
							System.out.println("[x,y,z]-" + "[" + nums[j] + "," + nums[secIndx] + "," + nums[i] + "]");
						}

					}
				}

			}
		}

		return rt;
	}

}
