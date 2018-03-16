#!/bin/bash
# add username
sudo adduser --home /var/lib/jenkins --disabled-password --gecos "" jenkins
# Add the jenkins to sudo group
usermod -aG sudo jenkins
# set password
echo "jenkins:jenkins" | chpasswd

sudo su jenkins
wget -q -O - https://pkg.jenkins.io/debian-stable/jenkins.io.key | sudo apt-key add -
echo 'deb https://pkg.jenkins.io/debian-stable binary/' > /etc/apt/sources.list.d/jenkins.list
sudo apt-get update
sudo apt-get install -y jenkins
sudo apt-get install -y default-jdk
