# 🏎️ Otonom Araç Güvenlik Koridoru Analiz Sistemi

Bu proje; otonom sürüş sistemlerinde aracın çevresel verilerini analiz ederek, güvenli hareket alanını (**Safety Corridor**) yapay zeka ile belirleyen bir yazılım modülüdür.

## 🎯 Projenin Amacı
Otonom araçların karmaşık trafik koşullarında, engel ve sınırları dikkate alarak "güvenli bölge" içerisinde kalmasını sağlamak. Proje, toplanan sensör verilerini **SVM (Support Vector Machine)** algoritmasıyla işleyerek aracın güvenli rotada olup olmadığını gerçek zamanlıya yakın bir hızda analiz eder.

## 🛠️ Teknik Yetenekler
* **Yapay Zeka Entegrasyonu:** Support Vector Machine (SVM) kullanarak veri sınıflandırma.
* **Gelişmiş Görselleştirme:** Eğitim verilerinin ve karar sınırlarının (Decision Boundaries) dinamik olarak grafik üzerinde sunulması.
* **Modüler Mimari:** Veri toplama, eğitim ve analiz süreçlerinin birbirinden bağımsız, genişletilebilir yapısı.

## 📊 Analiz Süreci Nasıl İşliyor?
1. **Veri Toplama:** Araç koordinatları ve çevresel etiketler `DataPoint` sınıfıyla sisteme beslenir.
2. **Model Eğitimi:** `SVMTrainer`, verilen parametrelerle (`TrainingConfig`) en uygun güvenlik modelini oluşturur.
3. **Karar Mekanizması:** `SafetyCorridorAnalyzer`, mevcut rotanın güvenlik koridoru içerisinde kalıp kalmadığını denetler.
4. **Görsel Raporlama:** `UnifiedVisualizer` ile sonuçlar kullanıcıya grafiksel bir arayüzle sunulur.

## 📂 Paket Yapısı
- `core/`: Algoritma motoru ve analiz mantığı.
- `entity/`: Veri modelleri ve konfigürasyon yapıları.
- `presentation/`: Kullanıcı arayüzü ve görselleştirme bileşenleri.

---
