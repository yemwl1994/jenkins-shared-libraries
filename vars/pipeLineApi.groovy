def call() {
    echo "call each function as pipeLineApi.functionName()"
}

def applicationPipeline(Map configMap) {
    application = configMap.get("application","")

    switch(application) {
        case 'mavenVM':
            mavenVM()
            break
        
        default:
            echo "Unrecognised application: ${config.application}"
            break
    }
}