node {
  stage('echo') {
    sh 'echo "Hello World"'
    sh '''
        echo "Multiline shell steps works too"
        ls -lah
    '''
  }
}
