maklashev@Ubuntu2204:~/final_exam$ history

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

    5  mkdir fom

    6  mv friendsofman.txt fom

    7  sudo add-apt-repository ppa:mysql/ppa

    8  sudo wget https://dev.mysql.com/get/mysql-apt-config_0.8.26-1_all.deb

    9  sudo dpkg -i mysql-apt-config_0.8.26-1_all.deb 

   10  sudo apt  get update

   11  sudo apt-get update

   12  sudo apt-get install mysql-server

   13  sudo wget <http://ftp.de.debian.org/debian/pool/main/g/gimp/gimp_2.10.8-2_amd64.deb>

   14  sudo dpkg -i gimp_2.10.8-2_amd64.deb

   15  sudo dpkg -r gimp
