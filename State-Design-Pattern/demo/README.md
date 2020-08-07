# State Design Pattern
Bir nesnenin durumu de�i�tirildi�inde davran���n�n de�i�tirildi�i tasar�m deseni.

### Power interface
Power interface ile davran��� belirliyoruz.
```
public interface Power {
	public void keyPress();
}
```
### On State
On state bilgisiyar�n a��k olma durumu
```
public class On implements Power {
	@Override
	public void keyPress() {
		System.out.println("Bilgisayar a��l�yor");
	}
}
```
### Of State
Of State bilgisayar�n kapal� olma durumu
```
public class Off implements Power {
	@Override
	public void keyPress() {
		System.out.println("Bilgisayar kapan�yor");
	}
}
```
### Computer Class
Computer S�n�f�nda bilgisayar�n durumunun de�i�tirilmesi keyPress fonksiyonlar� �a��r�l�nda ger�ekle�iyor.
A��k ise kapat�l�yor ve kapal� ise a��k durumuna getiriliyor.
```
public class Computer {

	public Power power;

	public Computer() {
		this.power = new Off();
	}

	public void keyPress() {
		power.keyPress();
	}

	public void turnOfComputer() {
		System.out.println("Power tu�una bas�ld� !");
		power = new Off();
	}

	public void turnOnComputer() {
		System.out.println("Power tu�una bas�ld� !");
		power = new On();
	}
}

```


