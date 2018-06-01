package dao;

public class CategoryDao extends BaseDao {

	public static void main(String[] args) {
		// 增删改的sql

		String sql = "update category set cname=? where cid=?";
		int row = execUpdateData(sql, "高清电视", "2548D083640C45A8BDEDB62FAA25E7F6");
		System.out.println(row);
	}

}
