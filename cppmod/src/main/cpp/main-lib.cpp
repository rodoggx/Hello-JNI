#include <jni.h>
#include <string>

extern "C"
jstring
Java_com_example_rodoggx_hellojni_MainActivity_string1FromJNI(
        JNIEnv *env,
        jobject obj) {
    std::string hello = "Example of JNI with C++";
    return env->NewStringUTF(hello.c_str());
}

extern "C"
jstring
Java_com_example_rodoggx_hellojni_MainActivity_string2FromJNI(
        JNIEnv *env,
        jobject obj) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}

