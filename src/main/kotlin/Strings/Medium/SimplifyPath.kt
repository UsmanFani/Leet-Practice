package Strings.Medium

//@author Usman Fani
class SimplifyPath {

    // "/home"
    // "/.."
    // "/."
    // "///"
    // "/..home.."
    // "/.../."
    // "/home/file/.."
    fun simPath(path: String): String {
        val str = StringBuilder()
        var isTextAvail = true
        var dotCount = 0
        path.forEach {
            str.append(it)
            if (it != '.' && it != '/') isTextAvail = true
            if (it == '/') {
                if (str.length > 1 && str[str.lastIndex - 1] == '/') str.deleteCharAt(str.lastIndex)
                else if (dotCount in 1..2 && !isTextAvail) {
                    repeat(dotCount) {
                        if (str.length > 1) str.deleteCharAt(str.lastIndex)
                        while (str.length > 1 && str.last() != '/') str.deleteCharAt(str.lastIndex)
                    }
                }
                dotCount = 0
                isTextAvail = false
            }
            if (it == '.') dotCount++
        }

        if (dotCount in 1..2 && !isTextAvail) {
            repeat(dotCount) {
                if (str.length > 1) str.deleteCharAt(str.lastIndex)
                while (str.length > 1 && str.last() != '/') str.deleteCharAt(str.lastIndex)
            }
            dotCount = 0
            isTextAvail = false
        }

        if (str.length > 1 && str.last() == '/') str.deleteCharAt(str.lastIndex)

        return str.toString()
    }
}