# Multi Thread Samurai Sudoku

Özet—Bu çalışmada çoklu threadler, nesneye yönelik
programlama paradigması, arayüz ögeleri ve ile bir sudoku
sistemi gerçekleştirdik. Multithread üzerinde senkron bir
şekilde, farklı threadler üzerinden çeşitli işlemler
gerçekleştirdik ve bir arayüz üzerinden elde edilen çıktıları
sunduk.
Anahtar kelimeler—Thread, Multithread Asenkron
Programlama, Sudoku MultiThread
## I. GIRIŞ VE PROBLEM TANIMI
Gerçekleştirdiğimiz proje her ne kadar samurai sudoku
olarak gözükse de asıl nokta aynı zamanda çalışan farklı
threadler üzerinden senkronize bir şekilde sistemle etkileşime
girebilmekti. Bu etkileşimler threadler arasında olası
çakışmaların yaşanabileceği eylemlerdi. Bu işlemleri
gerçekleştirirken threadlerin senkronize bir şekilde çalışması
kadar veri yapılarının da uygunluğu oldukça önemliydi.
Karşılaşılabilecek olası problemlerin çözümü için spesifik
yöntemler uygulanması gerekiyordu. Bu sistemi
gerçekleştirirken projeyi farklı kısımlara ayırmak faydalı
olacaktı. Program mimarisi genel olarak çoklu threadler ve
senkronizasyon, ile arayüzden oluşmaktadır. Raporun
ilerleyen kısımlarında bu kısımların teknik özelliklerine
ayrıntılı bir şekilde tekrar değineceğiz.
İlk etapta farklı amaçlara hizmet eden threadleri
oluşturduk. Nesnelerimizi soyutlayacak sınıfları yazdık ve
gerekli veri yapılarını bu sınıflar içerisinde tanımladık. Daha
sonrasında threadlerin ilgili işlemleri gerçekleştirecek
metotlarını yazdık. Threadlere gereken öncelikleri atadık.
Veri yapılarını thread safe bir hale getirdik ve
senkronizasyonu sağladık. Daha sonrasında da yine bir
thread olan arayüz ile sistemden gerekli çıktıları elde ettik.
## II.YÖNTEMLER,YAKLAŞIMLAR VE PROGRAM MIMARISI
Bu kısımda programın farklı özelliklerini oluşturmak için
kullandığımız araçlar ve yöntemler üzerinde durularak
ayrıntılı olarak bilgi verilecektir. Program mimarisi daha
detaylı bir şekilde açıklanacaktır.
## III. ÇOKLU THREADLER VE SENKRANİZASYON
Projede gerçeklenmesi gereken bazı threadler
bulunmaktaydı bunlar her bir satır ve sutunu kontrol
eden ve bizim eklediğimiz arayüz threadleriydi.
Öncelikle her bir thread için Runnable Interface’ini
implement ederek gerekli thread objesini oluşturduk.
Program çalışmaya başladığı anda threadleri
startlayarak override ettiğimiz run fonksiyonlarını giriş
noktası olarak çalıştırdık ve her threadimiz çalışmaya
başladı. Bu noktada threadlerin gerekli zamanlama
işlemleri için threadi belli süreleri baz alarak join
durumuna getirdik.. Her bir threadde sudoku çözümleri
kontrol edildi.Eğer tum koşullar sağlanıyor ise
fonksiyonlardan true dönüşü alındır ve işlemler
gerçekleştirildi
## IV. YAPILAN ARAŞTIRMALAR
Threadler arasındaki senkronizasyonu tam
sağlamadan önce direkt olarak proje iskeletini
kurmaya çalışmamız ve çıktıyı görüntüleme isteğimiz
ile beraber çeşitli thread exceptionlarıyla karşılaştık.
Bunların hepsini yukarıda bahsettiğimiz çeşitli
yöntemler ile gidersekte bu bize bir takım zaman
kaybı yaşattı.
## V. TASARIM
Sistem içerisindeki threadler sürekli işlemler
gerçekleşiyor ve ilgili yapılar en sonunda doğru
sayıları bularak program sonuna geliniyordu. Bu
yapıların anlık olarak görüntülenmesi için 2 adet
kullanıcı arayüzü oluşturduk. Arayüzü netbeans’in
form editörü aracılığıyla oluşturduk. Arayüz şablonu
oluştuktan sonra artık anlık olarak değerleri alıp çıktı
olarak vermemiz gerekiyordu. Bu noktada
arayüzümüzü bir jframe dosyası olarak oluşturduk.2
adet arayüze sahiptik Belli zaman aralıklarında tüm
verileri okuyarak ilgili değerlerini alıp komponentler
üzerinde görüntülüyordu ve bunun için bir takım
yardımcı kütüphaneler kullandık.Görseller aşağıdaki
gibidir;

 ![image](https://user-images.githubusercontent.com/56557278/152228794-c222e255-726f-471c-ba35-59cef7ddbfbe.png)

Şekil 1 1.Sudoku Ekranı

 ![image](https://user-images.githubusercontent.com/56557278/152228842-36d59894-4150-4cc5-8b3b-7e87191d6bb0.png)

Şekil 2 1.Sudoku Grafik Ekranı


 ![image](https://user-images.githubusercontent.com/56557278/152228863-4ad71c1e-8a0a-4c82-9867-b016f50b4240.png)


Şekil 3 2.Sudoku Gui Ekranı

 ![image](https://user-images.githubusercontent.com/56557278/152228893-ce92e455-9a37-4df5-b62a-21d91743cb85.png)

Şekil 4 2.Sudoku Grafik Ekranı


## VI.	YAZILIM MİMARİSİ

Projenin yürütülebilmesi açısında kullanılan bazı temel fonksiyonlar vardı.Bunlardan bazılar sunlardı;

containsInRow(): For döngüsü ile her bir satırda gönderilen sayının olup olmadığını kontrol eden fonksiyondur. Eğer satır içinde tekrar eden fonksiyon var ise false değeri yok ise true değeri döndürür.

containsInCol():For döngüsü ile her bir sütünda gönderilen sayının olup olmadığını kontrol eden fonksiyondur. Eğer sutun  içinde tekrar eden fonksiyon var ise false değeri yok ise true değeri döndürür.
containsInBox():Her bir matrisin içindeki 3x3’lük matrisleri kontrol eden fonksiyondur.Eğer matris içinde tekrar eden fonksiyon var ise false değeri yok ise true değeri döndürür.

isAllowed(): containsInRow, containsInCol, containsInBox fonksiyonlarının her birinde dönen değeri kontrol eder üç fonksiyonunda true değer döndürmesi beklenir.

solveSudoku ():İç içe for döngüleri ile satır ve sütunların uygunluğunu kontrol eder  en son isAllowed fonksiyonuna yollanır ve true değer dönüyor ise matrislere atama yapan temel fonskiyonumuz

run():Bir iş parçacığı yani thread başlatıldığındaiş parçacığı canlanmış olarak kabul edilir.Bu iş parçacığı run metodu sonlandığında iş parçacığınında canlılığı sonlanır





 

## VII.	AKIŞ DİYAGRAMI VE KABA KOD

 
![image](https://user-images.githubusercontent.com/56557278/152228928-737768a0-fe10-406e-8794-39c57386c53f.png)


Şekil 5 Akış Diyagramı












## VIII.	KABA KOD

Başla
txt dosyasından verileri oku
Verileri 5 matris olarak 2 boyutlu diziye ata
10 adet thread oluştur
t1 adlı threadde 1 ve 3. matrisleri Matris sınıfına yolla
threadi başlat
t2 adlı threadde 2 ve 3. matrisleri Matris sınıfına yolla
threadi başlat
t3 adlı threadde 3, ve 5 matrisleri Matris sınıfına yolla
threadi başlat
t4 adlı threadde 4. matrisi Matris sınıfına yolla
threadi başlat
t5 adlı threadde 5. matrisi Matris sınıfına yolla
threadi başlat
Matris sınıfında containsInRow() fonksiyonu ile satırları kontrol et
Matris sınıfında containsInCol() fonksiyonu ile sutunları kontrol et
Matris sınıfında containsInBox() fonksiyonu ile 3*3 matrisi kontrol et
Matris sınıfında isAllowed fonksiyonu ile tüm fonksiyoların true döndüğünü kontrol et
Thread run fonk(). ile matrisleri kontrol et
Uygun matrileri solveSudoku() fonksiyonu  ile sudoku çözümünü yap
textyaz() fonksiyonu ile doğru sudoku adımlarını txt yazdır
t6,t7,t8,t9,t10,t11,t12,t13,t14,t15 adlı threadleri Matris sınıfına yolla
threadleri başlat
Matrıs sınıfındaki adımları Matris1 de tekrarla
System.nanoTime() fonksiyonu ile threadler arasındakı süreleri hesapla
Sudoku gui'sine sayı değerleri yolla
Paint fonksiyonu ile Grafik çizimini gerçekleştir
Sudoku sınıfında paint fonksiyonu ile çizimleri yap
Matrisleri ekrana yazdır
Sudoku1 sınıfında paint fonksiyonu ile çizimleri yap
Matrisleri ekrana yazdır
BİTİR


## IX.	KAZANIMLAR

Projeyi gerçekleştirirken bir çok kazanım elde ettik. Diğer gerçekleştirdiğimiz projelerimizde de çeşitli amaçlarla thread kullanmıştık fakat genelde kullandığımız bu threadler farklı görevleri gerçekleştirmek üzerine çalışıyordu. Bu  sefer ise ortak işler gerçekleştiren threadlerle karşılaştık ve bu da beraberinde bir çok problem ortaya çıkardı. Bunları çözerken threadlerin genel işleyişi, senkronizasyon ve bunu sağlayan anahtar kelime, blok gibi konularda araştırmalar yaparak çeşitli bilgiler edindik. Ayrıca thread multithread çalışırken karşılaşılan çeşitli sorunların önüne nasıl geçtiklerini öğrenerek deneyimledik.



 

## X.	GELIŞTIRME ORTAMI VE KULLANILAN DIL
Projeyi Java programlama dilinde Windows işletim sistemi üzerinde gerçekleştirirken, geliştirme ortamı olarak Netbeans idesini kullandık. 

## XI.	YAPILAN ARAŞTIRMALAR
Projeyi gerçekleştirmeden önce birtakım araştırmalar yaptık. Bu  kısımda yaptığımız araştırmalardan bahsedeceğiz.
İlk araştırmalarımız threadlerin genel yapısı ve mantığı hakkındaydı. Her ne kadar daha önce kullansak da temel noktalarda bilmediğimiz şeyleri öğrendik ve bildiklerimizi detaylandırdık. Farklı tanımlamaları ve kullanım yöntemlerini öğrendik.
Tüm bu araştırmalarımızla birlikte kazanımlar bölümünde de bahsettiğimiz tüm kazanımlara sahip olmuş olduk.

## XII.	DENEYSEL SONUÇLAR
Proje sonunda elde ettiğimiz sonuçlar  multithread olarak çalışan bir programın içerisinde hata ayıklama işlemi yapmak oldukça zor bir hal alıyordu. Farklı threadlerin farklı zamanlarda çalışması hatanın tespitini oldukça güç bir hale getiriyordu. Bu noktada hata yakalamak için çeşitli yöntemler denememiz ve uygulamamız gerekti. Kimi zaman test amaçlı threadleri durdurmak, uyutmak gibi işlemler ile hataları yakalamaya çalıştık. Try-catch bloklarını daha aktif kullanarak karşılaşmasak bile gelecekte ayıklaması zor olacağı için tüm istisnaları yakalamaya çalıştık.

## XIII.	SONUÇ
Bu projeyi gerçekleştirerek senkronize bir şekilde çalışan multi thread ile bir sudoku oluşturmayı grafik çizdirmeyi başardık. Çeşitli thread işlemleri kullandık, arayüz işlemlerini ve isterleri gerçekleştirdik.

