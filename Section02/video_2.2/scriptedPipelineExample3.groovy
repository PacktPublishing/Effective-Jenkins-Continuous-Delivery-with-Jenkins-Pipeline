node {
  stage('list directory') {
    if (isUnix()) {
      sh 'ls -la'
    } else {
      bat 'dir'
    }
  }
}
