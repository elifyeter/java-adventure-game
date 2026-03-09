
public class ToolStore extends NormalLoc {

	ToolStore(Player player) {
		super(player, "Mağaza");
	}

	public boolean getLocation() {
		System.out.println("Para : "+player.getMoney());
		System.out.println("1. Silahlar");
		System.out.println("2. Zırhlar");
		System.out.println("3. Çıkış");
		System.out.print("Seçiminiz : ");
		int selTool = scan.nextInt();
		int selItemID;
		
		switch (selTool) {
		case 1:
			selItemID = weaponMenu();
			buyWeapon(selItemID);
			break;
		case 2:
			selItemID = armorMenu();
			buyArmor(selItemID);
			break;
		default:
			break;
		}
		
		return true;
		
	}
	
	public  int armorMenu() {
		System.out.println("1- Hafif \t Para : 15 \t Hasar : 1");
		System.out.println("2- Orta \t Para : 25 \t Hasar : 3");
		System.out.println("3- Ağır \t Para : 40 \t Hasar : 5");
		System.out.println("4- Çıkış");
		System.out.print("Silah Seçiniz :");
		int selArmorID = scan.nextInt();
		return selArmorID;		
	}
	
	public void buyArmor(int itemID) {
		int avoid = 0,price = 0;
		String armorName = null;
		
		switch(itemID) {
		case 1:
			avoid = 1;
			armorName = "Hafif Zırh";
			price = 15;
			break;
		case 2: 
			avoid = 3;
			armorName = "Orta Zırh";
			price = 25;
			break;
		case 3:
			avoid = 5;
			armorName = "Ağır Zırh";
			price = 40;
			break;
		case 4:
			System.out.println("Çıkış Yapılıyor.");
			break;
		default:
			System.out.println("Geçersiz İşlem !");
			break;	
		}
		
		if(price > 0) {
			if(player.getMoney() >= price ) {
				player.getInv().setArmor(avoid);
				player.getInv().setArmorName(armorName);
				player.setMoney(player.getMoney() - price);
				System.out.println(armorName+" satın aldınız, Engellenen Hasar : "+player.getInv().getArmor());
				System.out.println("Kalan Para : " + player.getMoney());
			}else {
				System.out.println("Bakiye yetersiz !");
			}
		}
	}
	
	public int weaponMenu() {
		System.out.println("1- Tabanca \t Para : 25 \t Hasar : 2");
		System.out.println("2- Kılıç \t Para : 35 \t Hasar : 3");
		System.out.println("3- Tüfek \t Para : 45 \t Hasar : 7");
		System.out.println("4- Çıkış");
		System.out.print("Silah Seçiniz :");
		int selWeaponID = scan.nextInt();
		return selWeaponID;
	}
	
	public void buyWeapon(int itemID) {
		int damage = 0,price = 0;
		String weaponName = null;
		
		switch(itemID) {
		case 1:
			damage = 2;
			weaponName = "Tabanca";
			price = 25;
			break;
		case 2: 
			damage = 3;
			weaponName = "Kılıç";
			price = 35;
			break;
		case 3:
			damage = 7;
			weaponName = "Tüfek";
			price = 45;
			break;
		case 4:
			System.out.println("Çıkış Yapılıyor.");
			break;
		default:
			System.out.println("Geçersiz İşlem !");
			break;	
		}
		
		if(price > 0) {
			if(player.getMoney() >= price ) {
				player.getInv().setDamage(damage);
				player.getInv().setWeaponName(weaponName);
				player.setMoney(player.getMoney() - price);
				System.out.println(weaponName+" satın aldınız, Önceki Hasar : "+player.getDamage()
				+", Yeni Hasar : "+ player.getTotalDamage() );
				System.out.println("Kalan Para : " + player.getMoney());
			}else {
				System.out.println("Bakiye yetersiz !");
			}
		}
		
		
		
	}
}
