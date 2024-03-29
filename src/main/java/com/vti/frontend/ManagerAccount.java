package com.vti.frontend;

import java.sql.SQLException;
import java.util.List;

import com.vti.backend.presentation.ControllerImpl;
import com.vti.backend.presentation.IController;
import com.vti.entity.Account;
import com.vti.exc.AccountNotFoundException;
import com.vti.utils.ScannerUtil;

public class ManagerAccount {
	private IController controller;

	public ManagerAccount() {
		controller = new ControllerImpl();
		menu();
	}

	private void menu() {
		int selected = 0;
		do {
			System.out.println("=====>Quản lý tài khoản<=====");
			System.out.println("1: In danh sách tk.");
			System.out.println("2: Tìm tk theo UserName");
			System.out.println("3: Xóa tk.");
			System.out.println("4: Tạo tài khoản mới.");
			System.out.println("5: Sửa tk");
			System.out.println("6: Thoát.");
			selected = ScannerUtil.scInt();
			switch (selected) {
			case 1:
				printListAccount();
				break;
			case 2:
				findAccount();
				break;
			case 3:
				deleteAcc();
				break;
			case 4:
				createAccount();
				break;
			case 5:
				updateAccount();
				break;
			case 6:
				System.out.println("Thoát chương trình.");
				break;
			default:
				System.out.println("Chọn sai chức năng.");
				break;
			}
		} while (selected != 6);

	}

	private void updateAccount() {
		System.out.println("------ 5. Update tai khoan --------");
		System.out.print("Nhập id tk cần sửa: ");
		int oldId = ScannerUtil.scInt();
		String newUserName = null;
		String newEmail = null;
		String message = null;

		System.out.println("Chọn 1 -> sửa userName, 2-> sửa Email, 3-> sửa email và userName:");
		switch (ScannerUtil.scInt()) {
		case 1:
			System.out.print("Nhập UserName mới: ");
			newUserName = ScannerUtil.scString();
			break;
		case 2:
			System.out.println("Nhập Email mới: ");
			newEmail = ScannerUtil.scString();
			break;
		case 3:
			System.out.print("Nhập UserName mới: ");
			newUserName = ScannerUtil.scString();
			System.out.println("Nhập Email mới: ");
			newEmail = ScannerUtil.scString();
			break;
		default:
			System.out.println("chọn sai chức năng.");
			return;
		}
		try {
			message = controller.updateAccount(oldId, newUserName, newEmail);
		} catch (SQLException e) {
			message = "Lỗi update => " + e.getMessage();
		}
		System.out.println(message);
	}

	private void createAccount() {
		System.out.println("----- 4. Tạo tài khoản ------ ");
		Account account = new Account();
		account.scanInfo();
		try {
			if (controller.createAccount(account)) {
				System.out.println("Tạo tk thành công.");
			} else {
				System.out.println("Tạo tk thất bại.");
			}
		} catch (SQLException e) {
			System.err.println("Tạo tk thất bại =>" + e.getMessage());
		}
	}

	private void findAccount() {
		System.out.println("-------- 2. Tìm tài khoản theo UserName ----------");
		System.out.print("Nhập UserName cần tìm: ");
		String uName = ScannerUtil.scString();

		Account account = null;

		try {
			account = controller.findAccountByUserName(uName);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (account != null) {
			System.out.println(account);
		} else {
			System.out.println("Không tìm thấy tài khoản phù hợp.");
		}
	}

	/**
	 * Phương thức in danh sách Account
	 * 
	 * @throws SQLException
	 */
	private void printListAccount() {
		System.out.println(" ----------- 1. In Danh sách tài khoản -----------");
		System.out.println();
		List<Account> listAcc = null;
		try {
			listAcc = controller.getAllAccount();
		} catch (SQLException e) {
			System.err.println("Xảy ra lỗi => " + e.getMessage());
			return;
		}

		if (listAcc == null || listAcc.isEmpty()) {
			System.out.println("Danh sách rỗng");
		} else {
			System.out.println(String.format(" %3s | %-30s| %-10s", "ID", "Email", "UserName"));
			System.out.println("----------------------------------------------------");
			for (Account account : listAcc) {
				System.out.println(account.stringTable());
			}
		}
		System.out.println();
	}

	private void deleteAcc() {
		// xoa account => nhap username hoac nhap id
		System.out.printf("Nhap username can xoa: ");
		String userName = ScannerUtil.scString();

		// xoa duoc => true , khong xóa đc trả về false
		boolean accDeleted;
		try {
			accDeleted = controller.deleteAcc(userName);
			if (accDeleted) {
				System.out.println("Xóa thành công.");
			} else {
				System.out.println("Xóa thất bại.");
			}
		} catch (AccountNotFoundException e) {
			System.err.println("Lỗi không tìm thấy account : " + userName);
		} catch (SQLException e) {
			System.err.println("Lỗi xóa account : " + e.getMessage());
		} catch (Exception e) {
			System.err.println("Lỗi xóa account : " + e.getMessage());
		}
	}

}
