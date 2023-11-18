fun main(args: Array<String>)
{
    val firemen = arrayOf("Pugh", "Pugh", "Barney McGrew", "Cuthbert", "Dibble", "Grub")
    var firemenNo = 0

    while (firemenNo < 6)
    {
        println("Firemen number $firemenNo is ${firemen[firemenNo]}")
        firemenNo++
    }
}