#!/bin/bash
# add username
sudo adduser --disabled-password --gecos "" jenkins
# Add the jenkins to sudo group
sudo usermod -aG sudo jenkins
#Add a group called docker
sudo groupadd docker
#Add the jenkins user to this group
sudo usermod -aG docker jenkins

# set password
echo "jenkins:jenkins" | chpasswd

# remove old instalation of docker
sudo apt-get remove -y docker docker-engine docker.io

# Add docker GPG Key
curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo apt-key add -
sudo add-apt-repository \
   "deb [arch=amd64] https://download.docker.com/linux/ubuntu \
   $(lsb_release -cs) \
   stable"

sudo apt-get update
sudo apt-get install -y default-jdk
sudo apt-get install -y\
    linux-image-extra-$(uname -r) \
    linux-image-extra-virtual

sudo apt-get install -y\
    apt-transport-https \
    ca-certificates \
    curl \
    software-properties-common

sudo apt-get install -y docker-ce

sudo reboot
