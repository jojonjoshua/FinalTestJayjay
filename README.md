Final Project Jayjay
Library Testing yang digunakan ada 2 yaitu
- Rest Assured untuk testing API
- Selenium untuk testing Web UI
Cucumber sebagai typing Scenario dengan menggunakan Gherkin Format (step automation)
Github Actions sebagai CI/CD
Project ini menggunakan POM (Page Object Model)

Untuk scenario dibagi ke dalam 2 file cucumber yaitu api.feature dan web.feature yang disimpan dalam folder feature
Scenario terdiri dari Positive dan Negative Testing
Testing API adalah melakukan pengetesan pada API https://gorest.co.in/
Testing Web UI adalah melakukan pengetesan pada Web UI https://www.saucedemo.com/

Pada Folder Build Gradle berisi dependencies yang berisi library untuk melakukan testing API dan juga Web UI

Testing API
File ApiStep digunakan untuk menjalankan scenario yang terbentuk dari api.feature
File ApiPages digunakan untuk menjalankan fungsi yang ada di ApiStep dengan menyambungkan ke ApiStep. Jadi semua code yang berhubungan dengan ApiStep akan di generate di ApiPage
File Hooks digunakan untuk menjalankan urutan testing yang akan dijalankan, karena di testing ini menggunakan JUnit makan anotations yang dipakai adalah milih JUnit
File ApiRunner digunakan untuk manajemen Test yang berlangsung. jadi test scenario bisa langsung di Run semua bersamaan
File Endpoint digunakan untuk manajemen Endpoint supaya tidak mengganggu jalanyna test apabila ada perbaikan jadinya tidak harus melakukan koreksi satu persatu
File Models digunakan untuk melakukan komunikasi dengan restAssured untuk penghitan API
Folder JSONSchemaData akan berisi file jsonschema yang berisikan respon json dari testing yang dijalankan
File Utility digunakan untuk mengambil data JSONSchema untuk bisa dipanggil di ApiPage

Testing Web UI
File WebiStep digunakan untuk menjalankan scenario yang terbentuk dari api.feature
File WebPages digunakan untuk menjalankan fungsi yang ada di ApiStep dengan menyambungkan ke ApiStep. Jadi semua code yang berhubungan dengan ApiStep akan di generate di WebPage
File Utility digunakan untuk memanggil driver setelah dan sesudah melakukan testing
File Hooks digunakan untuk memanggil driver setelah dan sesudah melakukan testing

Testing dilakukan dengan menjalankan sesuai dengan scenario yang telah dibuat. Scenario akan dijalankan dari yang pertama sampai yang terakhir (positive dan negative testing)
