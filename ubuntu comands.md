### 1. Используя команду cat в терминале операционной системы Linux, создать два файла Домашние животные (заполнив файл собаками, кошками,хомяками) и Вьючные животными заполнив файл Лошадьми, верблюдами и ослы), а затем объединить их. Просмотреть содержимое созданного файла. Переименовать файл, дав ему новое имя (Друзья человека).


    1  cat > pets.txt << EOF

    собаки

    кошки

    хомяки

    EOF

    2  cat > packanimals.exe << EOF

    лошади

    верблюды

    ослы

    EOF

    3  cat pets.txt packanimals.exe > friendsofman.txt

    4  cat friendsofman.txt 

### 2. Создать директорию, переместить файл туда.


    5  mkdir fom

    6  mv friendsofman.txt fom

    7  sudo add-apt-repository ppa:mysql/ppa

### 3. Подключить дополнительный репозиторий MySQL. Установить любой пакет из этого репозитория.

    8  sudo wget https://dev.mysql.com/get/mysql-apt-config_0.8.26-1_all.deb

    9  sudo dpkg -i mysql-apt-config_0.8.26-1_all.deb 

    10  sudo apt  get update

    11  sudo apt-get update

    12  sudo apt-get install mysql-server

### 4. Установить и удалить deb-пакет с помощью dpkg

    13  sudo wget <http://ftp.de.debian.org/debian/pool/main/g/gimp/gimp_2.10.8-2_amd64.deb>

    14  sudo dpkg -i gimp_2.10.8-2_amd64.deb

    15  sudo dpkg -r gimp
