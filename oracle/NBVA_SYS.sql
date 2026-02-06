CREATE USER product
IDENTIFIED BY Va1722002
DEFAULT TABLESPACE SYSTEM
TEMPORARY TABLESPACE temp
QUOTA UNLIMITED ON SYSTEM;

GRANT CREATE SESSION TO product;
GRANT CREATE TABLE TO product;
GRANT CREATE VIEW TO product;
GRANT CREATE SEQUENCE TO product;
GRANT CREATE PROCEDURE TO product;

create or replace PROCEDURE                  "GET_DANH_SACH_MENU_PHAN_QUYEN_V2" 
(
    p_id IN VARCHAR2,
    p_maPhanHe IN VARCHAR2,
    p_cursor OUT SYS_REFCURSOR
) AS 
BEGIN
    OPEN p_cursor FOR
    WITH PermissionHierarchy ("id", "tenNhomQuyen", "linkNhomQuyen", "loaiNhomQuyen", "nhomQuyenChaId","maNhomQuyen" , "icon", "maQuyen") AS (
        -- CTE đệ quy bắt đầu từ các quyền cấp 3
        SELECT  
            nq."id", 
            nq."tenNhomQuyen", 
            nq."linkNhomQuyen", 
            nq."loaiNhomQuyen", 
            nq."nhomQuyenChaId", 
            nq."maNhomQuyen",
            nq."icon",
            q."maQuyen"
        FROM 
            "NguoiDungThuocNhom" ndtn
        INNER JOIN 
            "NhomNguoiDung" nnd ON ndtn."nhomNguoiDungId" = nnd."id" AND nnd."isDel" = 0
        INNER JOIN 
            "VaiTroNhomNguoiDung" vtnd ON nnd."id" = vtnd."nhomNguoiDungId" AND vtnd."isDel" = 0
        INNER JOIN 
            "VaiTro" vt ON vtnd."vaiTroId" = vt."id" AND vt."isDel" = 0
        INNER JOIN 
            "QuyenVaiTro" qvt ON qvt."vaiTroId" = vt."id" AND qvt."isDel" = 0
        INNER JOIN 
            "Quyen" q ON qvt."quyenId" = q."id" AND q."isDel" = 0
        INNER JOIN 
            "NhomQuyen" nq ON nq."id" = q."nhomQuyenId" AND nq."isDel" = 0
        INNER JOIN 
            "PhanHe" phanHe ON phanHe."id" = nq."phanHeId" AND phanHe."maPhanHe" = p_maPhanHe AND phanHe."isDel" = 0
        WHERE 
            ndtn."nguoiDungId" = p_id
            AND ndtn."isDel" = 0

        UNION ALL 

        SELECT  
            nq."id", 
            nq."tenNhomQuyen", 
            nq."linkNhomQuyen", 
            nq."loaiNhomQuyen", 
            nq."nhomQuyenChaId", 
            nq."maNhomQuyen",
            nq."icon",
            NULL AS "maQuyen"
        FROM 
            "NhomQuyen" nq
        INNER JOIN 
            PermissionHierarchy ph ON nq."id" = ph."nhomQuyenChaId"
    )
    SELECT 
        "id", 
        "tenNhomQuyen", 
        "linkNhomQuyen", 
        "loaiNhomQuyen", 
        "nhomQuyenChaId", 
        "maNhomQuyen",
        "icon",
        LISTAGG("maQuyen", ',') AS "dsMaQuyen"
    FROM 
        PermissionHierarchy
    GROUP BY 
        "id", 
        "tenNhomQuyen", 
        "linkNhomQuyen", 
        "loaiNhomQuyen", 
        "nhomQuyenChaId", 
        "maNhomQuyen",
        "icon";
END GET_DANH_SACH_MENU_PHAN_QUYEN_V2;

