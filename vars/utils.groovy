void call() {
    echo "please call each methods as utils.methodName()"
}


public String determineBitBucketRepoName() {
    return scm.getUserRemoteConfigs()[0].getUrl().tokenize('/').last()
}

public String determinBitBucketAppcode() {
    return scm.getUserRemoteConfigs()[0].getUrl().split('/')[2].toUpperCase();
}