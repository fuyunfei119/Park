package com.example.parkplatz.Repositry;

import com.example.parkplatz.Entity.Parker;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ParkerRepositry {

    @Select("SELECT * FROM parker")
    List<Parker> FindSet();

    @Insert("INSERT INTO parker(id,entryDate,seasonParker,licensePlate) VALUES (#{id},#{entryDate},#{seasonParker},#{licensePlate})")
    Integer InsertNewParker(Parker parker);

    @Select("SELECT * FROM parker WHERE id = #{id}")
    Parker GetParkerByID(@Param("id") String id);

    @Update("UPDATE parker SET exitDate = #{exitDate}, parkingFee = #{parkingFee} WHERE id = #{id}")
    Integer UpdateParkerOnAfterCheckOut(Parker parker);
}
