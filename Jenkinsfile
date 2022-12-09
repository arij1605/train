pipeline{
	
	agent any 
	stages{
		stage ('Checkout GIT'){
			steps{
				echo 'Pulling...';
					git branch: 'main',
					url : 'https://github.com/arij1605/train',
					credentialsId: 'git-token';
			}
		}

		stage ('Verification du  version Maven...'){
			steps{
				sh "mvn -version"
			}
		}
        stage ("Suppression du dossier tareget + Copie du livrable dans le Repository local"){
			steps{
				sh "mvn clean install"
			}
			
		}
		stage("Compile"){
                    steps {
                        sh 'mvn compile -DskipTests'
                    }
                }
        stage ('Lancement des Tests Unitaires...'){
			steps{
				sh "mvn test"
			}
		}
		stage ('Création du livrable dans target'){
			steps{
				sh "mvn package"

			}
		}
    }
    }
