//package com.program.upviews.util;
//
//import static com.google.common.collect.Lists.newArrayList;
//import static com.google.common.collect.Sets.newHashSet;
//import com.program.upviews.repository.RoleRepository;
//import java.util.List;
//import java.util.Optional;
//import java.util.Set;
//import org.modelmapper.ModelMapper;
//import org.springframework.stereotype.Component;
//import org.springframework.util.Assert;
//import ro.fortech.eresume.dto.*;
//import ro.fortech.eresume.entity.*;
//import ro.fortech.eresume.repository.*;
//
//@Component
//public class Mapper {
//
//    private final RoleRepository roleRepository;
//
//    private final DatabaseRepository databaseRepository;
//
//    private final DevToolRepository devToolRepository;
//
//    private final TestToolRepository testToolRepository;
//
//    private final MethodologyRepository methodologyRepository;
//
//    private final OperationSystemRepository operationSystemRepository;
//
//    private final TechnologyRepository technologyRepository;
//
//    private final EncryptUtil encryptUtil;
//
//    private final ModelMapper modelMapper;
//
//    public Mapper(RoleRepository roleRepository, DatabaseRepository databaseRepository, DevToolRepository devToolRepository,
//                  TestToolRepository testToolRepository, MethodologyRepository methodologyRepository,
//                  OperationSystemRepository operationSystemRepository,
//                  TechnologyRepository technologyRepository, EncryptUtil encryptUtil,
//                  ModelMapper modelMapper) {
//        this.roleRepository = roleRepository;
//        this.databaseRepository = databaseRepository;
//        this.devToolRepository = devToolRepository;
//        this.testToolRepository = testToolRepository;
//        this.methodologyRepository = methodologyRepository;
//        this.operationSystemRepository = operationSystemRepository;
//        this.technologyRepository = technologyRepository;
//        this.encryptUtil = encryptUtil;
//        this.modelMapper = modelMapper;
//    }
//
//
//    /**
//     * Searches for the role from project request, in the database
//     * If is not found, the new role is saved in the database
//     *
//     * @param projectDto request
//     * @return Set of roles that are contained in projects.
//     */
//    public Set<RoleEntity> getRoles(ProjectDto projectDto) {
//        Set<RoleEntity> roleEntities = newHashSet();
//        Assert.notNull(projectDto.getRoles(), "Roles must not be null!");
//        Assert.notEmpty(projectDto.getRoles(), "Roles must not be empty!");
//        projectDto.getRoles().forEach(role -> {
//            Assert.notNull(role.getRoleName(), "Role name must not be null!");
//            Assert.hasLength(role.getRoleName(), "Role must not be empty!");
//            Optional<RoleEntity> roleEntity = roleRepository.findByRoleName(role.getRoleName());
//            RoleEntity savedRoleEntity = roleEntity.isEmpty()
//                    ? new ModelMapper().map(roleRepository.save(RoleEntity.builder().roleName(role.getRoleName()).build()),
//                    RoleEntity.class)
//                    : roleEntity.get();
//            roleEntities.add(savedRoleEntity);
//        });
//
//        return roleEntities;
//    }
//
//
//    /**
//     * Searches for the database from professional summary request, in the database
//     * If is not found, the new database object is saved in the database
//     *
//     * @param professionalSummaryDto request
//     * @return Set of databases that are contained in professional summary.
//     */
//    public Set<DatabaseEntity> getDatabases(ProfessionalSummaryDto professionalSummaryDto) {
//        Set<DatabaseEntity> databaseEntities = newHashSet();
//        Assert.notNull(professionalSummaryDto.getDatabaseDtos(), "Databases must not be null!");
//       professionalSummaryDto.getDatabaseDtos().forEach(database -> {
//            Assert.notNull(database.getDbName(), "Database name must not be null!");
//            Assert.hasLength(database.getDbName(), "Database name must not be empty!");
//            Optional<DatabaseEntity> databaseEntity = databaseRepository.findByDbName(database.getDbName());
//            DatabaseEntity savedDatabaseEntity = databaseEntity.isEmpty()
//                    ? new ModelMapper().map(databaseRepository.save(DatabaseEntity.builder().dbName(database.getDbName()).build()),
//                    DatabaseEntity.class)
//                    : databaseEntity.get();
//            databaseEntities.add(savedDatabaseEntity);
//        });
//
//        return databaseEntities;
//    }
//
//
//    /**
//     * Searches for the dev tools from professional summary request, in the database
//     * If is not found, the new dev tool object is saved in the database
//     *
//     * @param professionalSummaryDto request
//     * @return Set of devTools that are contained in professional summary.
//     */
//    public Set<DevToolEntity> getDevTools(ProfessionalSummaryDto professionalSummaryDto) {
//        Set<DevToolEntity> devToolEntities = newHashSet();
//        Assert.notNull(professionalSummaryDto.getDevToolDtos(), "DevTools must not be null!");
//        professionalSummaryDto.getDevToolDtos().forEach(devtool -> {
//            Assert.notNull(devtool.getDevToolName(), "DevTool name must not be null!");
//            Assert.hasLength(devtool.getDevToolName(), "DevTool name must not be empty!");
//            Optional<DevToolEntity> devtoolEntity = devToolRepository.findByDevToolName(devtool.getDevToolName());
//            DevToolEntity savedDevToolEntity = devtoolEntity.isEmpty()
//                    ? new ModelMapper().map(devToolRepository.save(DevToolEntity.builder().devToolName(devtool.getDevToolName()).build()),
//                    DevToolEntity.class)
//                    : devtoolEntity.get();
//            devToolEntities.add(savedDevToolEntity);
//        });
//
//        return devToolEntities;
//    }
//
//
//    /**
//     * Searches for the dev tools from professional summary request, in the database
//     * If is not found, the new dev tool object is saved in the database
//     *
//     * @param professionalSummaryDto request
//     * @return Set of devTools that are contained in professional summary.
//     */
//    public Set<TestToolEntity> getTestTools(ProfessionalSummaryDto professionalSummaryDto) {
//        Set<TestToolEntity> testToolEntities = newHashSet();
//        Assert.notNull(professionalSummaryDto.getTestToolDtos(), "TestTools must not be null!");
//        professionalSummaryDto.getTestToolDtos().forEach(tesTool -> {
//            Assert.notNull(tesTool.getTestToolName(), "TestTool name must not be null!");
//            Assert.hasLength(tesTool.getTestToolName(), "DevTool name must not be empty!");
//            Optional<TestToolEntity> testToolEntity = testToolRepository.findByTestToolName(tesTool.getTestToolName());
//            TestToolEntity savedTestToolEntity = testToolEntity.isEmpty()
//                    ? new ModelMapper().map(testToolRepository.save(TestToolEntity.builder().testToolName(tesTool.getTestToolName()).build()),
//                    TestToolEntity.class)
//                    : testToolEntity.get();
//            testToolEntities.add(savedTestToolEntity);
//        });
//
//        return testToolEntities;
//    }
//
//
//    /**
//     * Searches for the methodologies from professional summary request, in the database
//     * If is not found, the new methodologies object is saved in the database
//     *
//     * @param professionalSummaryDto request
//     * @return Set of methodologies that are contained in professional summary.
//     */
//    public Set<MethodologyEntity> getMethodologies(ProfessionalSummaryDto professionalSummaryDto) {
//        Set<MethodologyEntity> methodologyEntities = newHashSet();
//        Assert.notNull(professionalSummaryDto.getMethodologyDtos(), "Methodologies must not be null!");
//        professionalSummaryDto.getMethodologyDtos().forEach(methodology -> {
//            Assert.notNull(methodology.getMethodologyName(), "Methodology name must not be null!");
//            Assert.hasLength(methodology.getMethodologyName(), "Methodology name must not be empty!");
//            Optional<MethodologyEntity> methodologyEntity = methodologyRepository.findByMethodologyName(methodology.getMethodologyName());
//            MethodologyEntity savedMethodologyEntity = methodologyEntity.isEmpty()
//                    ? new ModelMapper().map(methodologyRepository.save(MethodologyEntity.builder().methodologyName(methodology.getMethodologyName()).build()),
//                    MethodologyEntity.class)
//                    : methodologyEntity.get();
//            methodologyEntities.add(savedMethodologyEntity);
//        });
//
//        return methodologyEntities;
//    }
//
//
//    /**
//     * Searches for the operation systems from professional summary request, in the database
//     * If is not found, the new operation system object is saved in the database
//     *
//     * @param professionalSummaryDto request
//     * @return Set of operation system objects that are contained in professional summary.
//     */
//    public Set<OperationSystemEntity> getOperationSystems(ProfessionalSummaryDto professionalSummaryDto) {
//        Set<OperationSystemEntity> osEntities = newHashSet();
//        Assert.notNull(professionalSummaryDto.getOperationSystemDtos(), "Operation Systems must not be null!");
//        professionalSummaryDto.getOperationSystemDtos().forEach(os -> {
//            Assert.notNull(os.getOsName(), "Operation System name must not be null!");
//            Assert.hasLength(os.getOsName(), "Operation System name must not be empty!");
//            Optional<OperationSystemEntity> osEntity = operationSystemRepository.findByOsName(os.getOsName());
//            OperationSystemEntity savedOsEntity = osEntity.isEmpty()
//                    ? new ModelMapper().map(operationSystemRepository.save(OperationSystemEntity.builder().osName(os.getOsName()).build()),
//                    OperationSystemEntity.class)
//                    : osEntity.get();
//            osEntities.add(savedOsEntity);
//        });
//
//        return osEntities;
//    }
//
//
//    /**
//     * Searches for the technology from project request, in the database
//     * If is not found, the new technology is saved in the database
//     *
//     * @param projectDto request
//     * @return Set of technologies that are contained in projects.
//     */
//    public Set<TechnologyEntity> getTechnologies(ProjectDto projectDto) {
//        Set<TechnologyEntity> technologyEntities = newHashSet();
//        Assert.notNull(projectDto.getTechnologies(), "Technologies must not be null!");
//        Assert.notEmpty(projectDto.getTechnologies(), "Technologies must not be empty!");
//        projectDto.getTechnologies().forEach(technology -> {
//            Assert.notNull(technology.getTechnologyName(), "Technology name must not be null!");
//            Assert.hasLength(technology.getTechnologyName(), "Technology name must not be empty!");
//            Optional<TechnologyEntity> technologyEntity = technologyRepository.findByTechnologyName(technology.getTechnologyName());
//            TechnologyEntity savedTechnologyEntity = technologyEntity.isEmpty()
//                    ? modelMapper.map(technologyRepository.save(TechnologyEntity.builder().technologyName(technology.getTechnologyName()).build()),
//                    TechnologyEntity.class)
//                    : technologyEntity.get();
//            technologyEntities.add(savedTechnologyEntity);
//        });
//
//        return technologyEntities;
//    }
//
//
//    /**
//     * Searches for the technology from project request, in the database
//     * If is not found, the new technology is saved in the database
//     *
//     * @param professionalSummaryDto request
//     * @return Set of technologies that are contained in projects.
//     */
//    public Set<TechnologyEntity> getTechnologies(ProfessionalSummaryDto professionalSummaryDto) {
//        Set<TechnologyEntity> technologyEntities = newHashSet();
//        Assert.notNull(professionalSummaryDto.getTechnologyDtos(), "Technologies must not be null!");
//        professionalSummaryDto.getTechnologyDtos().forEach(technology -> {
//            Assert.notNull(technology.getTechnologyName(), "Technology name must not be null!");
//            Assert.hasLength(technology.getTechnologyName(), "Technology name must not be empty!");
//            Optional<TechnologyEntity> technologyEntity = technologyRepository.findByTechnologyName(technology.getTechnologyName());
//            TechnologyEntity savedTechnologyEntity = technologyEntity.isEmpty()
//                    ? modelMapper.map(technologyRepository.save(TechnologyEntity.builder().technologyName(technology.getTechnologyName()).build()),
//                    TechnologyEntity.class)
//                    : technologyEntity.get();
//            technologyEntities.add(savedTechnologyEntity);
//        });
//
//        return technologyEntities;
//    }
//
//
//    /**
//     * @param project request
//     * @return List of roleDto from the project request
//     */
//    public List<RoleDto> mapRoles(ProjectEntity project) {
//        List<RoleDto> roleDtos = newArrayList();
//        project.getRoles().forEach(role -> {
//            RoleDto roleDto = modelMapper.map(role, RoleDto.class);
//            roleDto.setId(encryptUtil.encrypt(role.getId()));
//            roleDtos.add(roleDto);
//        });
//        return roleDtos;
//    }
//
//
//    /**
//     * @param professionalSummary request
//     * @return List of database objects from the professional summary request
//     */
//    public List<DatabaseDto> mapDatabase(ProfessionalSummaryEntity professionalSummary) {
//        List<DatabaseDto> databaseDtos = newArrayList();
//        professionalSummary.getDatabases().forEach(database -> {
//            DatabaseDto databaseDto = modelMapper.map(database, DatabaseDto.class);
//            databaseDto.setId(encryptUtil.encrypt(database.getId()));
//            databaseDtos.add(databaseDto);
//        });
//        return databaseDtos;
//    }
//
//
//    /**
//     * @param professionalSummary request
//     * @return List of devTool objects from the professional summary request
//     */
//    public List<DevToolDto> mapDevTool(ProfessionalSummaryEntity professionalSummary) {
//        List<DevToolDto> databaseDtos = newArrayList();
//        professionalSummary.getDevTools().forEach(devTool -> {
//            DevToolDto devToolDto = modelMapper.map(devTool, DevToolDto.class);
//            devToolDto.setId(encryptUtil.encrypt(devTool.getId()));
//            databaseDtos.add(devToolDto);
//        });
//        return databaseDtos;
//    }
//
//
//    /**
//     * @param professionalSummary request
//     * @return List of testTool objects from the professional summary request
//     */
//    public List<TestToolDto> mapTestTool(ProfessionalSummaryEntity professionalSummary) {
//        List<TestToolDto> testToolDtos = newArrayList();
//        professionalSummary.getTestTools().forEach(testTool -> {
//            TestToolDto testToolDto = modelMapper.map(testTool, TestToolDto.class);
//            testToolDto.setId(encryptUtil.encrypt(testTool.getId()));
//            testToolDtos.add(testToolDto);
//        });
//        return testToolDtos;
//    }
//
//
//    /**
//     * @param professionalSummary request
//     * @return List of methodology objects from the professional summary request
//     */
//    public List<MethodologyDto> mapMethodology(ProfessionalSummaryEntity professionalSummary) {
//        List<MethodologyDto> methodologiesDtos = newArrayList();
//        professionalSummary.getMethodologies().forEach(methodology -> {
//            MethodologyDto methodologyDto = modelMapper.map(methodology, MethodologyDto.class);
//            methodologyDto.setId(encryptUtil.encrypt(methodology.getId()));
//            methodologiesDtos.add(methodologyDto);
//        });
//        return methodologiesDtos;
//    }
//
//
//    /**
//     * @param professionalSummary request
//     * @return List of operation system objects from the professional summary request
//     */
//    public List<OperationSystemDto> mapOperationSystem(ProfessionalSummaryEntity professionalSummary) {
//        List<OperationSystemDto> osDtos = newArrayList();
//        professionalSummary.getOperationSystems().forEach(os -> {
//            OperationSystemDto osDto = modelMapper.map(os, OperationSystemDto.class);
//            osDto.setId(encryptUtil.encrypt(os.getId()));
//            osDtos.add(osDto);
//        });
//        return osDtos;
//    }
//
//
//    /**
//     * @param professionalSummary request
//     * @return technologyDtos from the project request
//     */
//    public List<TechnologyDto> mapTechnology(ProfessionalSummaryEntity professionalSummary) {
//        List<TechnologyDto> technologyDtos = newArrayList();
//        professionalSummary.getTechnologies().forEach(technology -> {
//            TechnologyDto technologyDto = modelMapper.map(technology, TechnologyDto.class);
//            technologyDto.setId(encryptUtil.encrypt(technology.getId()));
//            technologyDtos.add(technologyDto);
//        });
//        return technologyDtos;
//    }
//
//
//    /**
//     * @param project request
//     * @return technologyDtos from the project request
//     */
//    public List<TechnologyDto> mapTechnology(ProjectEntity project) {
//        List<TechnologyDto> technologyDtos = newArrayList();
//        project.getTechnologies().forEach(technology -> {
//            TechnologyDto technologyDto = modelMapper.map(technology, TechnologyDto.class);
//            technologyDto.setId(encryptUtil.encrypt(technology.getId()));
//            technologyDtos.add(technologyDto);
//        });
//        return technologyDtos;
//    }
//}
//
//
