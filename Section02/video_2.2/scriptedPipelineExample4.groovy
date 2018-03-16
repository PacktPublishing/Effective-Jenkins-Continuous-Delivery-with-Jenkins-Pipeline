node {
   stage('Checkout') {
      git 'https://github.com/effectivejenkins/my-awesome-project.git'
   }
   stage('Say Hello') {
         sh "./say_hello.sh"
   }
}
