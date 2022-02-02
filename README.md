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
## II.YÖNTEMLER,YAKLAŞIMLAR VE
PROGRAM MIMARISI
Bu kısımda programın farklı özelliklerini oluşturmak için
kullandığımız araçlar ve yöntemler üzerinde durularak
ayrıntılı olarak bilgi verilecektir. Program mimarisi daha
detaylı bir şekilde açıklanacaktır.
III. ÇOKLU THREADLER VE
SENKRANİZASYON
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
IV. YAPILAN ARAŞTIRMALAR
Threadler arasındaki senkronizasyonu tam
sağlamadan önce direkt olarak proje iskeletini
kurmaya çalışmamız ve çıktıyı görüntüleme isteğimiz
ile beraber çeşitli thread exceptionlarıyla karşılaştık.
Bunların hepsini yukarıda bahsettiğimiz çeşitli
yöntemler ile gidersekte bu bize bir takım zaman
kaybı yaşattı.
V. TASARIM
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
