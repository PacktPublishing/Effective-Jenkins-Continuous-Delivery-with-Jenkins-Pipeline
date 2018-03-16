/*
  You need to add a new credential first with id 'my_id_1'
  Go to Jenkins Dashboard > Credentials > System,
  then click on 'Global credentials (unrestricted)' and Add Credentials
*/
node {
  stage('use passwords') {
    withCredentials([usernameColonPassword(credentialsId: 'my_id_1', variable: 'MY_CREDENTIALS_1')]) {
      echo "My password is '${MY_CREDENTIALS_1}'!"
    }
  }
}
