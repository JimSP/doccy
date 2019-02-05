sudo apt-get install libpng-dev libjpeg-dev libtiff-dev zlib1g-dev
sudo apt-get install gcc g++
sudo apt-get install autoconf automake libtool checkinstall

wget http://www.leptonica.com/source/leptonica-1.77.0.tar.gz
tar -zxvf leptonica-1.77.0.tar.gz
./configure
make
sudo checkinstall
sudo ldconfig