public class SafeDie extends CombatDie {
    /**
     * Constructs a 6-sided die with the following faces:
     * <ul>
     * <li>3 Sword faces
     * <li>2 Shield faces
     * <li>1 Heal face
     * </ul>
     */
    public SafeDie() {
        faces = new DiceFace[6];
        faces[0] = new DiceFace(DiceFace.FaceType.SWORD, 1);
        faces[1] = new DiceFace(DiceFace.FaceType.SWORD, 1);
        faces[2] = new DiceFace(DiceFace.FaceType.SWORD, 1);
        faces[3] = new DiceFace(DiceFace.FaceType.SHIELD, 1);
        faces[4] = new DiceFace(DiceFace.FaceType.SHIELD, 1);
        faces[5] = new DiceFace(DiceFace.FaceType.HEAL, 1);
        faceUpIndex = 0;
    }
}
