/*
If you are using Gmail:
Jenkins Dashboard > Manage Jenkins > Configure System
Section: E-mail Notification
SMTP server: smtp.gmail.com
Use SMTP Authentication: yes
User name: Your full Gmail address (e.g. example@gmail.com)
Password: Your Gmail password
SMTP port: 465
Use SSL required: yes
*/
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
  } finally {
    stage('Send notification') {
      mail to: 'effectivejenkins@gmail.com',
           body: "Something is wrong with ${env.BUILD_URL}",
           subject: "Failed Pipeline: ${currentBuild.fullDisplayName}"
    }
  }
}
