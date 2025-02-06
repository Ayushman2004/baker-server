package com.mono.pgm.DbRepo;

import com.mono.pgm.Model.Pkg_info;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface Pkg_info_repo extends MongoRepository<Pkg_info,String>
{
}
