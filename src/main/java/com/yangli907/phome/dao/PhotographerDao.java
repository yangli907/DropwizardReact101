package com.yangli907.phome.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.yangli907.phome.model.Photographer;
import com.yangli907.phome.model.Tables;
import com.yangli907.phome.model.enums.PhotographerCategory;
import org.jooq.DSLContext;
import org.jooq.Record;

public class PhotographerDao {
    //TEST ONLY
    public static Map<String, Photographer> photographers;

    static {
        photographers = new HashMap<>();
        photographers.put("yangli907", new Photographer(1, "yangli907", "Yang Li", PhotographerCategory.Landscape, "Sunnyvale, CA", null, null));
        photographers.put("cobblest", new Photographer(2, "cobblest", "Youyang Hou", PhotographerCategory.Portrait, "Sunnyvale, CA", null, null));
    }

    private DSLContext database;

    public PhotographerDao(DSLContext database) {
        this.database = database;
    }

    public List<Photographer> getPhotographers() {
        return database.selectFrom(Tables.PHOTOGRAPHER).fetch().into(Photographer.class);
    }


    public  Photographer getPhotographer(String userId){
        Record record = database.selectFrom(Tables.PHOTOGRAPHER)
                                .where(Tables.PHOTOGRAPHER.USERID.equal(userId))
                                .fetchOne();
        return record == null ? null :
            record.into(Photographer.class);
    }

    public void updatePhotographer(String userId, Photographer photographer){
        database.insertInto(Tables.PHOTOGRAPHER,
                            Tables.PHOTOGRAPHER.USERID,
                            Tables.PHOTOGRAPHER.NAME,
                            Tables.PHOTOGRAPHER.CATEGORY,
                            Tables.PHOTOGRAPHER.LOCATION)
                .values(photographer.getUserId(),
                    photographer.getName(),
                    photographer.getCategory(),
                    photographer.getLocation())
                .execute();

        //photographers.put(userId, photographer);
    }

    public static void removePhotographer(Integer id){
        photographers.remove(id);
    }
}
