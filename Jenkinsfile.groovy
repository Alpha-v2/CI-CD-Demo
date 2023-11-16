def s3_source = "/home/ubuntu/FirstProject/workspace/First_Pipeline@2/target/FirstProject.war"

pipeline {
      agent {label "build_server"}
      stages {
      // Creating build job
        stage ("Building Maven War") {
          steps {
             sh "mvn clean install"

          }

        }
        stage ("Copy War to s3 bucket") {

        steps {

        sh "aws s3 cp ${s3_source} s3://cicd.demo"
        }
        }
      }

      build 'Test'
            
      }
