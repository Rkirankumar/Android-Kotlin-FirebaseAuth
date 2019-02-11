-printmapping mapping.txt

-optimizations !code/simplification/cast,!field/*,!class/merging/*
-optimizations !code/allocation/variable
-optimizationpasses 1
-allowaccessmodification
-dontpreverify
-dontobfuscate

# The remainder of this file is identical to the non-optimized version
# of the Proguard configuration file (except that the other file has
# flags to turn off optimization).

-dontusemixedcaseclassnames
-dontskipnonpubliclibraryclasses
-verbose

# Preserve some attributes that may be required for reflection.
-keepattributes *Annotation*,Signature,InnerClasses,EnclosingMethod

-keep public class com.google.vending.licensing.ILicensingService
-keep public class com.android.vending.licensing.ILicensingService
-keep public class com.google.android.vending.licensing.ILicensingService
-dontnote com.android.vending.licensing.ILicensingService
-dontnote com.google.vending.licensing.ILicensingService
-dontnote com.google.android.vending.licensing.ILicensingService

# For native methods, see http://proguard.sourceforge.net/manual/examples.html#native
-keepclasseswithmembernames class * {
    native <methods>;
}

# Keep setters in Views so that animations can still work.
-keepclassmembers public class * extends android.view.View {
    void set*(***);
    *** get*();
}
# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile
-keep public class * implements com.bumptech.glide.module.GlideModule
-keep public class * extends com.bumptech.glide.module.AppGlideModule
-keep public enum com.bumptech.glide.load.resource.bitmap.ImageHeaderParser$** {
  **[] $VALUES;
  public *;
}

# We want to keep methods in Activity that could be used in the XML attribute onClick.
-keepclassmembers class * extends android.app.Activity {
    public void *(android.view.View);
}

# For enumeration classes, see http://proguard.sourceforge.net/manual/examples.html#enumerations
-keepclassmembers enum * {
    public static **[] values();
    public static ** valueOf(java.lang.String);
}

-keepclassmembers class * implements android.os.Parcelable {
    public static final ** CREATOR;
}

-keepnames class * implements android.os.Parcelable {
    public static final ** CREATOR;
}

-keepclassmembers class **.R$* {
    public static <fields>;
}

# Preserve annotated Javascript interface methods.
-keepclassmembers class * {
    @android.webkit.JavascriptInterface <methods>;
}

# The support libraries contains references to newer platform versions.
# Don't warn about those in case this app is linking against an older
# platform version. We know about them, and they are safe.
-dontnote android.support.**
-dontwarn android.support.**

# Understand the @Keep support annotation.
-keep class android.support.annotation.Keep

-keep @android.support.annotation.Keep class * {*;}

-keepclasseswithmembers class * {
    @android.support.annotation.Keep <methods>;
}

-keepclasseswithmembers class * {
    @android.support.annotation.Keep <fields>;
}

-keepclasseswithmembers class * {
    @android.support.annotation.Keep <init>(...);
}

-keepattributes SourceFile,LineNumberTable
-keep,allowshrinking,allowoptimization class * { <methods>; }

-keep public class * extends java.lang.Exception
-dontwarn java.lang.invoke.*
-keep class com.crashlytics.** { *; }
-dontwarn com.crashlytics.**

-keep class org.apache.** { *; }
-dontwarn org.apache.**

-keep class android.util.FloatMath { *;}
-dontwarn android.util.FloatMath

-keep class com.google.android.exoplayer2.source.** {*;}
-dontwarn com.google.android.exoplayer2.source.**

-keepattributes *Annotation*
-keepattributes SourceFile,LineNumberTable
-keep public class * extends java.lang.Exception
-dontwarn java.lang.invoke.*
-keep class com.crashlytics.** { *; }
-dontwarn com.crashlytics.**

# To remove logging
-assumenosideeffects class android.util.Log {
    public static boolean isLoggable(java.lang.String, int);
    public static int v(...);
    public static int i(...);
    public static int w(...);
    public static int d(...);
    public static int e(...);
}

-keep class * extends java.util.ListResourceBundle {
    protected Object[][] getContents();
}

-keep public class com.google.android.gms.common.internal.safeparcel.SafeParcelable {
    public static final *** NULL;
}

-keepnames @com.google.android.gms.common.annotation.KeepName class *
-keepclassmembernames class * {
    @com.google.android.gms.common.annotation.KeepName *;
}

-dontnote retrofit2.Platform
# Platform used when running on Java 8 VMs. Will not be used at runtime.
-dontwarn retrofit2.**
# Retain generic type information for use by reflection by converters and adapters.
-keepattributes Signature
# Retain declared ic_checked exceptions for use by a Proxy instance.
-keepattributes Exceptions

-dontwarn okio.**
-dontwarn javax.annotation.**
-dontwarn com.squareup.okhttp3.**

# The Maps Android API uses serialization.
-keepclassmembers class * implements java.io.Serializable {
    static final long serialVersionUID;
    static final java.io.ObjectStreamField[] serialPersistentFields;
    private void writeObject(java.io.ObjectOutputStream);
    private void readObject(java.io.ObjectInputStream);
    java.lang.Object writeReplace();
    java.lang.Object readResolve();
}
-dontwarn com.android.installreferrer
-keep public class com.google.android.gms.* { public *; }
-dontwarn com.google.android.gms.**

# Add this global rule
-keepattributes Signature
-dontwarn com.google.android.gms.**
-dontwarn com.google.android.gms.internal.zzhu
-keep class com.google.android.gms.internal.** { *; }

# OkHttp
-dontwarn okhttp3.**
-dontwarn okio.**
-dontwarn javax.annotation.**
# A resource is loaded with a relative path so the package of this class must be preserved.
-keepnames class okhttp3.internal.publicsuffix.PublicSuffixDatabase

-keepattributes Signature
-keepattributes *Annotation*

-keepclassmembernames class kotlinx.** {
    volatile <fields>;
}

# Androidx
-keep class com.google.android.material.** { *; }
-dontwarn com.google.android.material.**
-dontnote com.google.android.material.**
-dontwarn androidx.**
-keep class androidx.core.app.CoreComponentFactory { *; }
-keep class androidx.** { *; }
-keep interface androidx.** { *; }
-keepclassmembers class androidx.lifecycle.** { *; }
-keep class androidx.lifecycle.* { *; }
-dontwarn androidx.lifecycle.*
-keepnames class android.arch.lifecycle.ViewModel