node {
  try {
    stage('echo') {
      sh 'echo "Hello World"'
      def obj = null
      sh "${obj.class}"
    }
  } catch (NullPointerException e) {
    error 'broken pipeline - null pointer exception'
    currentBuild.result = 'FAILURE'
    //currentBuild.result = 'UNSTABLE'
  }
}
