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
    }}
