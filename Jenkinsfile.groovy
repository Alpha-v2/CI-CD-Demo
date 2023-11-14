def s3_source = "/home/ubuntu/FirstProject/target/FirstProject.war"

Pipeline{
      agent{label "build_server"}
      Stages{
      // Creating build job
        Stage("Building Maven War"){
          Steps{
             sh "mvn clean install"

          }

        }
        Stage("Copy War to s3 bucket"){

        Steps{

        sh "s3 cp ${s3_source} s3://cicd.demo"
        }
        }
      }
      }
