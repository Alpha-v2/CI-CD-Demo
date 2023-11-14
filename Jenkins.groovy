def s3 source = "/home/ubuntu/FirstProject/target/FirstProject.war"

Pipeline{
      agent{label "build_server"}
      Stages{
      // Creating build job
        Stage(Building Maven Package){
          Steps{
             sh "mvn clean install"

          }

        }
        Stage(Copy War package to s3 bucket){

        Steps{

        sh "s3 cp ${s3 source} s3://cicd.demo"
        }
        }
      }
      }
