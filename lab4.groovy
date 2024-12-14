pipeline {
    agent any

    stages {
        stage('Deploy') {
            steps {
                ansiblePlaybook(
                    playbook: './ansible/firstPlaybook.yml',
                    inventory: '/.ansible/inventory',
                    hostKeyChecking: false,
                    disableHostKeyChecking: true,
                    credentialsId: '~/forbite960/.ssh/id_rsa',
                    
                )
            }
        }
        stage('Start') {
            steps {
                ansiblePlaybook(
                    playbook: './ansible/roles/deploy/tasks/main.yml',
                    inventory: '/.ansible/inventory',
                    hostKeyChecking: false,
                    disableHostKeyChecking: true,
                    credentialsId: '~/forbite960/.ssh/id_rsa',
                    
                )
            }
        }
    }
}