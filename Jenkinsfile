pipeline {
    agent any

    environment {
        // Environment variables
        DB_URL = "jdbc:mysql://localhost:3306/imagegallerydb"
        DB_USER = "root"
        DB_PASSWORD = "admin@123"
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main',
                    credentialsId: 'github-token', // Use the ID you set in Jenkins credentials
                    url: 'https://github.com/HabibullahAfzali/image-gallery.git'
                 }
                }
        stage('Checkout') {
            steps {
                // Clone the repository
                git 'https://github.com/YourUsername/YourProjectRepo.git'
            }
        }
        
        stage('Build Backend (Spring Boot)') {
            steps {
                script {
                    // Navigate to the backend folder and build the Spring Boot application
                    dir('backend') {
                        sh './mvnw clean install'
                    }
                }
            }
        }

        stage('Build Frontend (React)') {
            steps {
                script {
                    // Navigate to the frontend folder and install dependencies, then build the React app
                    dir('frontend/image-gallery') {
                        sh 'npm install'
                        sh 'npm run build'
                    }
                }
            }
        }

        stage('Run Docker (MySQL)') {
            steps {
                script {
                    // Pull and run MySQL Docker container
                    sh '''
                    docker-compose -f docker-compose.yml down
                    docker-compose -f docker-compose.yml up -d
                    '''
                }
            }
        }

        stage('Run Backend') {
            steps {
                script {
                    // Start the backend service
                    dir('backend') {
                        sh './mvnw spring-boot:run'
                    }
                }
            }
        }

        stage('Run Tests') {
            steps {
                script {
                    // Example to run tests (adjust as necessary)
                    dir('backend') {
                        sh './mvnw test'
                    }
                }
            }
        }
    }

    post {
        always {
            // Clean up Docker containers after running the pipeline
            sh 'docker-compose -f docker-compose.yml down'
        }
        success {
            echo 'Build and tests succeeded!'
        }
        failure {
            echo 'Build or tests failed.'
        }
    }
}
